<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="w-50">
		<h1>글쓰기</h1>
		<input type="text" id="subject" class="form-control" placeholder="제목을 입력하세요">
		<textarea rows="10" class="form-control" id="content" placeholder="글 내용을 입력하세요"></textarea>
		<div class="d-flex justify-content-end my-4">
			<input type="file" id="file" accept=".jpg, .jpeg, .png, .gif">
		</div>
		
		<div class="d-flex justify-content-between">
			<button type="button" id="postListBtn" class="btn btn-dark">목록</button>
			
			<div>
				<button type="button" id="clearBtn" class="btn btn-secondary">모두 지우기</button>
				<button type="button" id="saveBtn" class="btn btn-success">저장</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		//목록 버튼 클릭 => 목록페이지로 이동
		$("#postListBtn").on("click", function(){
			location.href="/post/post_list_view"
		});
		
		$("#clearBtn").on("click", function(){
			$("#subject").val("");
			$("#content").val("");
		});
		
		$("#saveBtn").on("click", function(){
			let subject = $("#subject").val().trim();
			let content = $("#content").val();
			let file = $("#file").val();	//이미지 경로  C:\fakepath\스크린샷(1).png 
			if(!subject){
				alert("제목을 입력해주세요");
				return;		// 클릭 이벤트면 return만 해도 됨
			}
			
			// alert(file);
			// 파일이 업로드 된 경우에만 확장자 체크
			if(file != ""){	// 파일이 비어있지 않을 때
				// 확장자만 뽑아서 소문자로 변경한다.
				let ext = file.split(".").pop().toLowerCase();	// .pop은 배열의 마지막 부분을 가져온다. .toLowerCase = 소문자로 바꿔준다
				//alert(ext);
				if($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1) {
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$("#file").val("");	// 파일을 비워준다.
					return;
				}
			}
			
			// 서버 AJAX
			// 이미지를 업로드 할 때는 form태그가 반드시 있어야 한다.
			// append함수는 폼태그의 name 속성과 같다.
			let formData = new FormData();
			formData.append("subject", subject);
			formData.append("content", content);
			formData.append("file", $("#file")[0].files[0]);
			
			$.ajax({
				// request
				type:"POST"
				, url:"/post/create"
				, data:formData
				, enctype:"multipart/form-data"	// file 업로드를 위한 필수 설정
				, processData:false	// file 업로드를 위한 필수 설정
				, contentType:false	// file 업로드를 위한 필수 설정
				
				// response
				, success:function(data){
					if (data.code == 1){
						// 성공
						alert("메모가 저장되었습니다.");
						location.href="/post/post_list_view";
					} else{
						// 실패
						alert(data.errorMessage)
					}
				}
				, error:function(request, status, error){
					alert("글을 저장하는데 실패했습니다.");
				}
			});
		});
	});
</script>