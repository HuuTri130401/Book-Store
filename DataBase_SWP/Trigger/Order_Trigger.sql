	/* VERSION TRIIGER CURSOR -> RESULT: FAIL 
							  -> REASON: EXECUTE TOO LONG

	alter trigger quantityBook on [dbo].[OrderDetail]
	after insert
	as
	begin 
		SET NOCOUNT ON;
		if exists(select [book_Id] from inserted)
			begin
			-- declare biến 
				declare @quantity_Book int
				declare @quantity_Order int
			-- declare cursor con trỏ for quantity book
				declare cursorBook cursor for
				select quantity_Book from [dbo].[Book]
								where [book_Id] in (select [book_Id] from inserted)
			-- declare cursor con trỏ for quantity order
				declare cursorOrder cursor for
				select [quantity_Order_Detail] from [dbo].[OrderDetail]
								where [book_Id] in (select [book_Id] from inserted)
			-- Open cursor
				Open cursorBook
				Open cursorOrder
			-- Đọc dòng đầu tiên
				Fetch next from cursorBook into @quantity_Book
				Fetch next from cursorOrder into @quantity_Order
			--vòng lặp WHILE khi đọc Cursor thành công
				while @@FETCH_STATUS =0
					begin
						update [dbo].[Book]
						set [quantity_Book] = @quantity_Book - @quantity_Order
						where [book_Id] in (select [book_Id] from inserted)
					end
			-- Đóng Cursor
				close cursorBook
				close cursorOrder
			-- Giải phóng tài nguyên
				Deallocate cursorBook
				Deallocate cursorOrder
			end
		else
			print 'Book_Id no exist in OrderDetail'
	end
*/

		/* VERSION TRIIGER CURSOR -> RESULT: FAI */
create trigger quantityBook_Order on [dbo].[OrderDetail]
	after insert
	as
	begin 
		SET NOCOUNT ON;
		if exists(select [book_Id] from inserted)
			begin

			-- declare biến 
				declare @book_id int
				select @book_id = [book_Id] from inserted

				declare @quantity_Book int
				select @quantity_Book=quantity_Book from [dbo].[Book]
								where [book_Id]=@book_id

				declare @quantity_Order int
				select @quantity_Order=[quantity_Order_Detail] from [dbo].[OrderDetail]
								where [book_Id]=@book_id

			-- update quantity book
				update [dbo].[Book]
				set [quantity_Book] = @quantity_Book - @quantity_Order
				where [book_Id]=@book_id
			end
		else
			print 'Book_Id no exist in OrderDetail'
	end
                   -- TEST Trigger on OderDetail --

-- insert [quantity_Order_Detail]
insert [dbo].[OrderDetail] ([order_Detail_Id],[order_Id],[book_Id],
							[quantity_Order_Detail],[total_Order_Detail])
values (6,2,/*[book_Id]*/8,/*quantity*/1,352.000)

-- view OrderDetail after insert
select *
from OrderDetail
where [order_Detail_Id]=5

-- test trigger works on table book
select [book_Id],[name],[quantity_Book]
from Book 
where [book_Id]=8

delete from OrderDetail where [order_Detail_Id]=10
