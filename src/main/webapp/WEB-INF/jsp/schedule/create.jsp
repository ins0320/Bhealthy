<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3 class="mt-5 ml-4">스케줄 표</h3>    
<!-- calendar --> 
<div class="padding:30px mt-4">
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
					slotMinTime: '09:00:00', // Day 캘린더에서 시작 시간        
					slotMaxTime: '23:59:59', // Day 캘린더에서 종료 시간
					selectable: true,
					navLinks: true,
					droppable: true,
					displayEventTime: true,
					editable: true,
					allDayDefault: true,
					allDay:false,
					allDaySlot: false,
					 customButtons: {
						mainButton:{
							text: '메인으로',
							click: function(arg) {
								location.href="/schedule/check-view";
							 }
						}, 
					    deleteButton: {
					      text: '모두 삭제하기',
					      click: function(arg) {
					        calendar.removeAllEvents();
				             $.ajax({
								 type:"delete",
								 url: "/schedule/deleteAll",		            	 
						         success:function(data){
						        	 if(data.code == 200){		
			                			 alert("일정이 모두 삭제되었습니다.");
			                			 location.reload();
			                		 }else if (data.code == 403){
			                			 alert("일정 삭제 권한이 없습니다.");
			                			 location.reload();
			                		 }  else{
			                			 alert("일정을 삭제하기 못했습니다.");
			                		 } 	
						          },
						         error:function(){
						         	alert("일정을 삭제하지 못했습니다. 관리자에게 문의 바랍니다.");
						         	 location.reload();
						         }                	
				          	});  
					      }
					    } 
					},
	               	headerToolbar: {
	                    left: 'prev,next,mainButton',
	                    center: 'title',
	                    right: 'deleteButton, timeGridDay'

	                },
	                locale: 'ko',      	
	                select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.  
	                
	                	var title = prompt('Event Title:');    
						///var userId = $(this).data("user-id");
		                if (title) {  
		                		calendar.addEvent({    
		                			title: title,     
		                			start: arg.start,     
		                			end: arg.end
		                		}) 
		                $.ajax({
		                	 type:"post",
		                	 url: "/admin/schedule/create",
		                	 data:{"title":title,"start":arg.start,"end":arg.end},
		                	 success:function(data){
		                		 if(data.code == 200 && title != ""){
		                			 alert("일정이 작성되었습니다.");
		                			 location.reload();
		                		 }else if (data.code == 403){
		                			 alert("일정 작성 권한이 없습니다.");
		                			 location.reload();
		                		 }  else{
		                			 alert("일정 작성에 실패했습니다.");
		                		 } 
		                	 },
		                	 error:function(){
		                		 alert("일정 작성에 실패했습니다. 관리자에게 문의 바랍니다.");
		                	 }                	
		                }); 
		               }
		                calendar.unselect()
	                }, // ---- select
	                droppable: true,
	                eventClick: function(arg) { 
	    				// 있는 일정 클릭시, 삭제하기 
	    				// alert("삭제하기");
	    				//alert(arg.event.title);
	    				var title = arg.event.title;
	    				// alert(title);
	    				if (confirm('일정을 삭제하시겠습니까?')) 
	    				{ 
	    					  $.ajax({
	    						  type: "DELETE",
	    						  url: "/schedule/detele",
	    						  data : {"title": title},
	    						  success : function(data){
	    							  if(data.code == 200){		
	 		                			 alert("일정이 삭제 되었습니다.");
	 		                			 location.reload();
	 		                		 }else if (data.code == 403){
	 		                			 alert("일정 삭제 권한이 없습니다.");
	 		                		 }  else{
	 		                			 alert("일정 삭제에 실패했습니다.");
	 		                		 } 
	    						  },
	    						  error : function(request,status,error){
	    							alert("일정 삭제에 실패했습니다.관리자에게 문의 바랍니다.");
	    						  }
	    					});  
	    					arg.event.remove();
	    				} 
	    			},
	                events: function(arg, successCallback, failureCallback) {
	           			 $.ajax({
	           				type: "get",
	        				url: "/schedule/list",
	        				success: function(data) {
	        					successCallback(data);
		                	 },
		                	 error:function(){
		                		 alert("일정 로드에 실패했습니다. 관리자에게 문의 바랍니다.");
		                	 }                		        				
	        			}); 
	        		}
	        		
	            });
	       	// 캘린더 랜더링  
	        calendar.render();
	     });
	  })();
	</script>
    