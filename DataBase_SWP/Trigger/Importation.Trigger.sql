create trigger quantityBook_Importation on [dbo].[ImportationDetail]
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

				declare @quantity_Import_Detail int
				select @quantity_Import_Detail=[quantity_Import_Detail] from [dbo].[ImportationDetail]
								where [book_Id]=@book_id

			-- update quantity book
				update [dbo].[Book]
				set [quantity_Book] = @quantity_Book + @quantity_Import_Detail
				where [book_Id]=@book_id
			end
		else
			print 'Book_Id no exist in ImportDetail'
	end
                   -- TEST Trigger on OderDetail --

-- insert [quantity_Order_Detail]
insert [dbo].[ImportationDetail] ([import_Detail_Id],[import_Id],[book_Id],
							[quantity_Import_Detail],[price_Import_Detail]
							,[total_Import_Detail],[note])
values (4,1,/*[book_Id]*/8,/*quantity*/3,70000,140000,'')

-- view OrderDetail after insert
select *
from [dbo].[ImportationDetail]
where [import_Detail_Id]=4

-- test trigger works on table book
select [book_Id],[name_Book],[quantity_Book]
from Book 
where [book_Id]=8
