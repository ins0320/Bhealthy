<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2 class="mt-5 ml-5">스케줄 등록하기</h2>    
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
					slotMinTime: '09:00', // Day 캘린더에서 시작 시간        
					slotMaxTime: '15:59', // Day 캘린더에서 종료 시간
					selectable: true,
					droppable: true,
					displayEventTime: true,
					editable: true,
					 customButtons: {
					    deleteButton: {
					      text: '모두 삭제하기',
					      click: function(arg) {
					        //calendar.removeAllEvents();
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
	                    right: 'deleteButton, timeGridDay'

	                },
	                locale: 'ko',      	

	                events: function(arg, successCallback, failureCallback) {
	           			 $.ajax({
	           				type: "get",
	        				url: "/booking/list",
	        				success: function(data) {
	        					successCallback(data);
		                	 },
		                	 error:function(){
		                		 alert("일정 로드 에러");
		                	 }                		        				
	        			}); 
	        		}
	        		
	            });
	       	// 캘린더 랜더링  
	        calendar.render();
	     });
	  })();
	</script>
    