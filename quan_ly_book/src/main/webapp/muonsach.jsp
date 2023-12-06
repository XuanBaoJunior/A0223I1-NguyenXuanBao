<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h1>Mượn sách</h1>
<div class="container">
    <form class="row g-3" method="post" action="/TheMuonSachServlet">
        <div>
            <label for="maMuon" class="form-label">Mã mượn</label>
            <input type="text" class="form-control" id="maMuon" name="maMuon" value="${bookToUpdate.ma_muon}">
        </div>
        <div>
            <label class="form-label">Tên Sách</label>
            <select id="inputState" class="form-select" name="bookSelect">
                <c:forEach items="${books}" var="b">
                    <c:if test="${bookToUpdate.book.id_book == b.id_book}">
                        <option  value="${b.id_book}" selected>${b.name_book}</option>
                    </c:if>
                    <c:if test="${bookToUpdate.book.id_book != b.id_book}">
                        <option  value="${b.id_book}">${b.name_book}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div>
            <label class="form-label">Tên học sinh</label>
            <select id="inputStudent" class="form-select" name="studentSelect">
                <c:forEach items="${students}" var="s">
                    <c:if test="${bookToUpdate.student.id_student == s.id_student}">
                        <option  value="${s.id_student}"  selected>${s.name_student}</option>
                    </c:if>
                    <c:if test="${bookToUpdate.student.id_student != s.id_student}">
                        <option  value="${s.id_student}" >${s.name_student}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <di>
            <label for="ngayMuon" class="form-label">Ngày mượn</label>
            <input type="text" class="form-control" id="ngayMuon" name="ngayMuon" value="${bookToUpdate.ngay_muon}">
        </di>
        <div>
            <label for="ngayTra" class="form-label">Ngày trả</label>
            <input type="text" class="form-control" id="ngayTra" name="ngayTra" value="${bookToUpdate.ngay_tra}">
        </div>

        <div class="col-12">
            <button><a id="muonSachLink" href="TheMuonSachServlet?action=findAllTheMuon">Mượn sách</a></button>

        </div>
    </form>
</div>
<script>
    var muonSachLink = document.getElementById("muonSachLink");

    muonSachLink.addEventListener("click", function() {
        window.location.href = "listbook.jsp";
    });
</script>

</body>
</html>