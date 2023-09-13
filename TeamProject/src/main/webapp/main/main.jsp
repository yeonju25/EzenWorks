<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="join/css/join.css">
 <title>회원 가입/수정</title>

 <script type="text/javascript" src="join/script/join.js"></script>

</head>
<body>
<%@ include file="../header/header.jsp" %>

<div id="top" align="center">

 <div id="join_layout">

  <div class="category">
   <ul>
    <li><a href="main?command=main">Home&nbsp;</a></li>
    <li>▶ 회원정보 입력</li>
   </ul>
  </div>

  <div class="join_title">
   <h3>회원정보 입력</h3>
  </div>

  <form action="main?command=join" method="post" name="frm" >
   <div id=member_info>
    <table class="member_table">
     <colgroup>
      <col style="width: 155px">
     </colgroup>
     <tr>
      <th>
       <div class="head_cell">
        <span>*</span>이 름
       </div>
      </th>
      <td>
       <div class="info_cell">
        <input style="width: 280px" type="text" name="name" size="15">
       </div>
      </td>
     </tr>
     <tr>
      <th>
       <div class="head_cell">
        <span>*</span>아이디
       </div>
      </th>
      <td>
       <div class="info_cell">
        <input style="width: 160px" type="text" name="id" size="10">
        <input type="hidden" name="reid" size=20>
        <input class="idcheck_bnt" type="button" value="중복체크" onclick="idCheck()">
       </div>
      </td>
     </tr>
     <tr>
      <th>
       <div class="head_cell">
        <span>*</span>비밀번호
       </div>
      </th>
      <td>
       <div class="info_cell">
        <input type="password" name="pass" size="15">
        <span class="pw_info">
										<br>* 영문 대소문자/숫자/특수문자를 혼용하여 2종류 10~16자 또는 3종류 8~16자
									</span>
       </div>
      </td>
     </tr>

     <tr>
      <th>
       <div class="head_cell">
        <span>*</span>비밀번호 확인
       </div>
      </th>
      <td>
       <div class="info_cell">
        <input type="password" name="pass_check" size="15">
       </div>
      </td>
     </tr>

     <tr>
      <th>
       <div class="head_cell">
        <span>*</span>이메일
       </div>
      </th>
      <td>
       <div class="info_cell">
        <input style="width: 350px" placeholder="예시 : abc@naver.com (@포함기입)" type="email" name="email" size="20">
       </div>
      </td>
     </tr>
     <!--
                             <tr>
                                 <th>
                                     <div class="head_cell">
                                         <span>*</span>주 소
                                     </div>
                                 </th>
                                 <td>
                                     <div class="info_cell_address">

                                         <input style="width: 150px" type="text" class="postcode" placeholder="우편번호">
                                         <input class="postcode_bnt" type="button" onclick="Postcode()" value="우편번호 찾기"><br>

                                         <label>도로명주소 (자동입력)</label>
                                         <input style="width: 400px" type="text" name="address" class="roadAddress" placeholder="우편번호찾기를 이용해주세요" readonly><br>
                                         <input type="hidden" id="jibunAddress" placeholder="지번주소">
                                     </div>
                                 </td>
                             </tr>
         -->
     <tr>
      <th>
       <div class="head_cell">
        <span>*</span>휴대폰
       </div>
      </th>
      <td>
       <div class="info_cell">
        <input style="width: 350px" placeholder="예시 : 010-1234-5678" type="text" name="phone" size="15">
       </div>
      </td>
     </tr>

     <tr>
      <th>
       <div class="head_cell">
        <span>*</span>등 급
       </div>
      </th>
      <td>
       <input class="admin1"  type="radio" name="admin" value="A" checked="checked"> 일반회원
       <input class="admin2" type="radio" name="admin" value="B"> 관리자
      </td>
     </tr>

    </table>
   </div>
   <!-- addInfo
 <div class="addInfo">
     <table>
         <tr>
             <th>
                 <div class="head_cell">피부타입</div>
             </th>
             <th>
                 <div class="info_cell">
                     <label>
                         <input type="radio">건성
                     </label>
                 </div>
             </th>

         </tr>
     </table>
 </div>
-->


   <div class="join_bnt">
    <input type="submit" value="가입하기" onclick="return joinCheck()">
   </div>



  </form>


 </div>
 <%@ include file="../footer/footer.jsp" %>

</div>

</body>
</html>