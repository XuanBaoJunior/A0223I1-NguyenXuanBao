use bai2_2;

	-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
	SELECT o_id, o_date, o_total_price
	FROM order_qlbh;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách--
SELECT 
    c_name,p_name
FROM 
    customer_qlbh
JOIN 
    order_qlbh o_id ON c_id = c_id
JOIN 
    order_detail o_id ON o_id = o_id
JOIN 
    product p_id ON p_id = p_id
ORDER BY 
    c_name, p_name;