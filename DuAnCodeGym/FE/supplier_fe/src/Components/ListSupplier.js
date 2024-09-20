import { Link } from "react-router-dom";
import * as supplierService from "../Service/supplierService";
import {useEffect, useState} from "react";

function ListSupplier() {
    const [suppliers, setSuppliers] = useState([]);
    const [selectedIds, setSelectedIds] = useState([]);
    const [productList, setProductList] = useState([]);
    const [selectedProductType, setSelectedProductType] = useState("");
    const [searchTerm, setSearchTerm] = useState("");
    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        ListProducts();
        ListSuppliers();
    }, []);

    const ListProducts = async () => {
        try {
            const temp = await supplierService.listSupplier();
            setProductList(temp);
        } catch (error) {
            console.error("Failed to fetch product list:", error);
        }
    };

    const ListSuppliers = async (productType = "", term = "") => {
        try {
            const temp = await supplierService.list(productType, term);
            setSuppliers(temp);
        } catch (error) {
            console.error("Failed to fetch suppliers:", error);
        }
    };


    const handleSearchTermChange = (e) => {
        setSearchTerm(e.target.value);
    };

    const handleSearch = () => {
        ListSuppliers(selectedProductType, searchTerm);
    };

    const handleSelectRow = (id) => {
        setSelectedIds((prevSelectedIds) =>
            prevSelectedIds.includes(id)
                ? prevSelectedIds.filter((itemId) => itemId !== id)
                : [...prevSelectedIds, id]
        );
    };

    const handleSelectAll = (e) => {
        if (e.target.checked) {
            setSelectedIds(suppliers.map((supplier) => supplier.id));
        } else {
            setSelectedIds([]);
        }
    };

    const handleDeleteSelected = async () => {
        try {
            await supplierService.deleteSuppliers(selectedIds);
            ListSuppliers(selectedProductType, searchTerm);
            setSelectedIds([]);
            setShowModal(false);
        } catch (error) {
            console.error("Failed to delete suppliers:", error);
        }
    };

    const handleShowModal = () => {
        if (selectedIds.length > 0) {
            setShowModal(true);
        }
    };

    const handleCloseModal = () => {
        setShowModal(false);
    };

    return (
        <div className="container mt-5">
            <form className="row mb-4">
                <div className="col-md-12 d-flex justify-content-between align-items-center">
                    <div className="input-group w-25 ms-auto">
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Tìm theo MS hoặc SDT"
                            aria-label="Search by term"
                            value={searchTerm}
                            onChange={handleSearchTermChange}
                        />
                        <button
                            className="btn btn-info"
                            type="button"
                            onClick={handleSearch}
                        >
                            Tìm kiếm
                        </button>
                    </div>

                </div>
            </form>

            <div className="d-flex justify-content-between mb-3">
                <Link to="/supplier/create" className="btn btn-info">Thêm nhà cung cấp</Link>
                <button
                    className="btn btn-danger"
                    onClick={handleShowModal}
                    disabled={selectedIds.length === 0}
                >
                Xóa
                </button>
            </div>

            <div className="table-responsive">
                <table className="table table-bordered">
                    <thead className="table-light">
                    <tr>
                        <th scope="col">
                            <input
                                type="checkbox"
                                onChange={handleSelectAll}
                                checked={suppliers.length > 0 && selectedIds.length === suppliers.length}
                            />
                        </th>
                        <th scope="col">STT</th>
                        <th scope="col">MS</th>
                        <th scope="col">Tên nhà cung cấp</th>
                        <th scope="col">Địa chỉ</th>
                        <th scope="col">SDT</th>
                        <th scope="col">E-mail</th>
                        <th scope="col">Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    {suppliers && suppliers.length > 0 ? (
                        suppliers.map((supplier, index) => (
                            <tr key={supplier.id}>
                                <td>
                                    <input
                                        type="checkbox"
                                        checked={selectedIds.includes(supplier.id)}
                                        onChange={() => handleSelectRow(supplier.id)}
                                    />
                                </td>
                                <td>{index + 1}</td>
                                <td>{supplier.uid}</td>
                                <td>{supplier.name}</td>
                                <td>{supplier.address}</td>
                                <td>{supplier.phone}</td>
                                <td>{supplier.email}</td>
                                <td>
                                    <Link to={`/supplier/update/${supplier.id}`} className="btn btn-warning">
                                        Cập nhật
                                    </Link>
                                </td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="8">Không có kết quả</td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>

            {/* Bootstrap Modal Delete */}
            <div
                className={`modal fade ${showModal ? 'show' : ''}`}
                id="deleteModal"
                tabIndex="-1"
                aria-labelledby="deleteModalLabel"
                aria-hidden={!showModal}
                style={{ display: showModal ? 'block' : 'none' }}
            >
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="deleteModalLabel">Xác nhận xóa</h5>
                            <button type="button" className="btn-close" aria-label="Close" onClick={handleCloseModal}></button>
                        </div>
                        <div className="modal-body">
                            Bạn có chắc chắn muốn xóa những đối tượng đã chọn?
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" onClick={handleCloseModal}>Hủy</button>
                            <button type="button" className="btn btn-danger" onClick={handleDeleteSelected}>Xóa</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ListSupplier;
