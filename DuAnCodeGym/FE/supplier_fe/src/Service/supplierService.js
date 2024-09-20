import axios from "axios";


export const list = async (productType = "", searchTerm = "", page = 0, size = 5, sortField = 'phone', sortOrder = 'desc') => {
    try {
        const response = await axios.get("http://localhost:1010/api/supplier/search", {
            params: {
                name: productType,
                search: searchTerm,
                page: page,
                size: size,
                sort: `${sortField},${sortOrder}`
            }
        });
        return response.data.content;
    } catch (err) {
        console.log(err);
    }
};


export const deleteSuppliers = async (ids) => {
    try {
        await axios.post(`http://localhost:1010/api/supplier/delete`, {ids});
    } catch (err) {
        console.log(err);
    }
};

export const listSupplier = async () => {
    try {
        let temp = await axios.get("http://localhost:1010/api/supplier");
        return temp.data.content;
    }catch (err){
        console.log(err);
    }
}