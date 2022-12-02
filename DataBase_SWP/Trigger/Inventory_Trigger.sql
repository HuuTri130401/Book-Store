create trigger quantityBook_Inventory on [dbo].[InventoryDetail]
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

				declare @quantity_Inventory int
				select @quantity_Inventory=[quantity_Inventory] from [dbo].[InventoryDetail]
								where [book_Id]=@book_id

			-- update quantity book
				update [dbo].[Book]
				set [quantity_Book] = @quantity_Book - @quantity_Inventory
				where [book_Id]=@book_id
			end
		else
			print 'Book_Id no exist in InventoryDetail'
	end
                   -- TEST Trigger on OderDetail --

-- insert [quantity_Order_Detail]
insert [dbo].[InventoryDetail] ([inventory_Detail_Id],[inventory_Id],[book_Id],
							[quantity_Inventory],[note])
values (4,1,/*[book_Id]*/8,/*quantity*/2,'')

-- view OrderDetail after insert
select *
from [dbo].[InventoryDetail]
where [inventory_Detail_Id]=4

-- test trigger works on table book
select [book_Id],[name],[quantity_Book]
from Book 
where [book_Id]=8
