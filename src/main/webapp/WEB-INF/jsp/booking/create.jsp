<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2 class="mt-5 ml-5">예약하기</h2>    
<!-- calendar --> 
<div class="padding:30px">
	<!-- calendar 태그 -->  
	<div id='calendar-container'>  
		<div id='calendar' class="calendar"></div> 
	</div>
	<!-- /calendar 태그 -->
</div>
<!-- /calendar -->
<script> 
		(function(){  
			$(function(){     
				// calendar element 취득   
				var calendarEl = $('#calendar')[0];   
				// full-calendar 생성하기  
				var calendar = new FullCalendar.Calendar(calendarEl, {     
					height: '500px', // calendar 높이 설정    
					expandRows: true, // 화면에 맞게 높이 재설정
					selectable: true,
					droppable: true,
			
					customButtons: {
					    deleteButton: {
					      text: '삭제하기',
					      click: function(arg) {
					        calendar.removeAllEvents();
					        alert("일정이 모두삭제되었습니다.");
				            /* $.ajax({
								 type:"post",
								 url: "/post/monthly/delete",		            	 
						         success:function(data){
						         	location.reload();			      
						          },
						         error:function(){
						         	alert("일정 삭제 에러");
						         }                	
				          	});  */
					      }
					    }
					},
	               	headerToolbar: {
	                    left: 'prev,next today',
	                    center: 'title',
	                    right: 'deleteButton'
	                },
	                locale: 'ko',
	                
	          	
	                select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.  
	                	var title = prompt('Event Title:');    

		                if (title) {  
		                		calendar.addEvent({    
		                			title: title,     
		                			start: arg.start,     
		                			end: arg.end            
		                		})         
		                 	}  
		                $.ajax({
		                	 type:"post",
		                	 url: "/post/monthly/create",
		                	 data:{"title":title,"start":arg.start,"end":arg.end},
		                	 success:function(data){
		                		 if(data.result == "success"){		                			 
		                			 location.reload();

		                		 }else{
		                			 alert("일정 작성 실패");
		                		 }
		                	 },
		                	 error:function(){
		                		 alert("일정 작성 에러");
		                	 }                	
		                }); 
	                	
	                }
	           		,events: function(arg, successCallback, failureCallback) {
	           			/* $.ajax({
	           				type: "get",
	        				url: "/post/monthly/list",
	        				success: function(data) {
	        					successCallback(data);
		                	 },
		                	 error:function(){
		                		 alert("일정 로드 에러");
		                	 }                		        				
	        			}); */
	        		},
	        		
	            });
	       	// 캘린더 랜더링  
	        calendar.render();
	     });
	  })();
	</script>
    