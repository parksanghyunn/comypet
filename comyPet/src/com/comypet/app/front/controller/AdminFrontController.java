package com.comypet.app.front.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.comypet.action.ActionForward;
import com.comypet.app.action.AdminAction;
import com.comypet.app.action.BoardAction;

public class AdminFrontController extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
	
		switch(command) {
		case "/AdminLoginOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminLoginOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/AdminAdmin.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminListOk");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/AdminCheckIdOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminCheckIdOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/AdminAddOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminAddOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/AdminMember.ad":
			try {
				forward = new AdminAction().execute(req, resp, "MemberListOk");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/AdminUpdateOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminUpdateMemberOkAction");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			// 자유게시판 
		case "/AdminBoardListFOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminBoardListF");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/AdminSearchBoardF.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminSearchBoardF");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/AdminSearchBoardM.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminSearchBoardM");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/AdminSearchBoardN.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminSearchBoardN");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/AdminSearchBoardQ.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminSearchBoardQ");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/AdminSearchAdminOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminSearchAdminOk");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		case "/AdminSearchMemberOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminSearchMemberOk");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
	     case "/AdminBoardListMOk.ad":
	    	 try {
				forward = new AdminAction().execute(req, resp, "AdminBoardListM");
	    	 }catch (Exception e1) {
	    		e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBoardListNOk.ad":
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBoardListN");
	    	 }catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBoardListQOk.ad":
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBoardListQ");
	    	 }catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminListGalleryP.ad": // 강아지갤러리 테이블에 뿌려주기
	    	 try {
				forward = new AdminAction().execute(req, resp, "AdminGalleryListP");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	 break;
	     case "/AdminListGalleryC.ad": // 고양이갤러리 테이블에 뿌려주기
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminGalleryListC");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminListGalleryD.ad": // 일상갤러리 테이블에 뿌려주기
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminGalleryListD");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminListGalleryE.ad": // 기타갤러리 테이블에 뿌려주기
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminGalleryListE");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminSearchGalleryP.ad": // 강아지갤러리에서 게시글 검색
	    	 try {
				forward = new AdminAction().execute(req, resp, "AdminSearchGalleryP");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	 break;
	     case "/AdminSearchGalleryC.ad": // 고양이갤러리에서 게시글 검색
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminSearchGalleryC");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminSearchGalleryD.ad": // 일상갤러리에서 게시글 검색
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminSearchGalleryD");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminSearchGalleryE.ad": // 기타갤러리에서 게시글 검색
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminSearchGalleryE");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindFOk.ad": // 자유게시판 게시글 블라인드 처리
	    	 try {
				forward = new AdminAction().execute(req, resp, "AdminBlindFOk");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	 break;
	     case "/AdminBlindMOk.ad": // 모임게시판 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindMOk");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindNOk.ad": // 나눔게시판 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindNOk");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindQOk.ad": // 질문게시판 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindQOk");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindPOk.ad": // 강아지갤러리 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindPOk");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindCOk.ad": // 고양이갤러리 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindCOk");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindDOk.ad": // 일상갤러리 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindDOk");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindEOk.ad": // 기타갤러리 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindEOk");
	    	 } catch (Exception e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminBlindLOk.ad": // 반려동물 찾기 게시글 블라인드 처리
	    	 try {
				forward = new AdminAction().execute(req, resp, "AdminBlindLOk");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	    	 break;
	     case "/AdminBlindSugOk.ad": // 불편사항 게시글 블라인드 처리
	    	 try {
	    		 forward = new AdminAction().execute(req, resp, "AdminBlindSugOk");
	    	 } catch (Exception e2) {
	    		 e2.printStackTrace();
	    	 }
	    	 break;
	    	//-------------------------------------------------------------------------------------------------------------------------------
	         //반려동물 찾기
	         //반려동물 찾기 게시판 리스트 뽑기
	         case "/AdminBoardListLOk.ad":
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminBoardListL");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	         case "/AdminSearchBoardL.ad":
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminSearchBoardL");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	         //광고문의
	         case "/AdminAdsBoardListOk.ad":
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminAdsBoardList");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	         //제휴문의
	            
	         case "/AdminSupBoardListOk.ad":
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminSupBoardList");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	         //불편사항
	         case "/AdminSugBoardListOk.ad":
	            System.out.println("불편사항");
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminBoardListS");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	         case "/AdminSearchBoardS.ad":
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminSearchBoardS");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	         //공지사항 찾기 게시판 리스트 뽑기
	         case "/AdminBoardListNoticeOk.ad":
	        	 System.out.println("공지사항");
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminBoardListNotice");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	         case "/AdminSearchBoardNotice.ad":
	            try {
	             forward = new AdminAction().execute(req, resp, "AdminSearchBoardNotice");
	          } catch (Exception e1) {
	             e1.printStackTrace();
	          }
	            break;
	            // 공지사항 게시글 수정
	         case "/AdminModifyNoticeOk.ad":
	        	 System.out.println("공지사항 게시글 수정들어옴");
	 			try {
	 				forward = new AdminAction().execute(req, resp, "AdminModifyNoticeOk");
	 			} catch (Exception e3) {
	 				e3.printStackTrace();
	 			}
	 			break;
	         case "/AdminDeleteOk.ad":
	        	 System.out.println("들어옴");
			try {
				forward = new AdminAction().execute(req, resp, "boardNoticeDeleteOkAction");
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			break;
	       
            //-------------------------------------------------------------------------------------------------------------------------------
	            //신고된 유저 접수 가져오기
         case "/AdminMemberReportReceiveOk.ad":
			try {
				forward = new AdminAction().execute(req, resp, "AdminMemberReportReceive");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
			//신고된 유저 검색해서 가져오기
         case"/AdminMemberReportReceiveSearch.ad":
        	 System.out.println("프론트 들어옴");
        	 try {
				forward = new AdminAction().execute(req, resp, "AdminMemberReportReceiveSearch");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        	 break;
         case"/AdminReportStateChangeOk.ad":
        	 try {
				forward = new AdminAction().execute(req, resp, "MemberReportStateUpdate");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        	 break;
         case"/AdminBoardReportReceiveOk.ad":
        	 try {
				forward = new AdminAction().execute(req, resp, "AdminBoardReportReceive");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        	 break;
        	 //상태 바꾸기
         case"/AdminBoardReportStateChangeOk.ad":
        	 try {
				forward = new AdminAction().execute(req, resp, "BoardReportStateUpdate");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        	 break;
        	 //검색하기
         case "/AdminBoardReportSearch.ad":
        	 try {
				forward = new AdminAction().execute(req, resp, "AdminBoardReportSearch");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        	 break;
         case "/BoardReportContents.ad":
        	 try {
				forward = new AdminAction().execute(req, resp, "AdminBoardReportContents");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        	 break;
        //게시판 정지 페이지로 이동
	     case "/BoardReport.ad":
	    	 try {
	    		 forward = new ActionForward();
	    		 forward.setRedirect(false);
	    		 forward.setPath("/app/admin/admin_board_report.jsp");
	    	 } catch (Exception e) {
	    		 e.printStackTrace();
	    	 }
	    	 break;
	     case "/BoardReportReceive.ad":
	    	 try {
	    		 forward = new ActionForward();
	    		 forward.setRedirect(false);
	    		 forward.setPath("/app/admin/admin_board_report_receive.jsp");
	    	 } catch (Exception e) {
	    		 e.printStackTrace();
	    	 }
	    	 break;
	    //유저 정지 페이지로 이동
	     case "/report.ad":
	    	 try {
	    		 forward = new ActionForward();
	    		 forward.setRedirect(false);
	    		 forward.setPath("/app/admin/admin_member_report.jsp");
	    	 } catch (Exception e) {
	    		 e.printStackTrace();
	    	 }
	    	 break;
	    //유저 신고된 페이지로 이동
	     case"/reportReceive.ad":
	    	 try {
				forward = new ActionForward();
				 forward.setRedirect(false);
				 forward.setPath("/app/admin/admin_member_report_receive.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	 break;
//	     case "/customer.ad":
//	    	 try {
//	    		 forward = new ActionForward();
//	    		 forward.setRedirect(false);
//	    		 forward.setPath("/app/admin/admin_CustomerService.jsp");
//	    	 } catch (Exception e) {
//	    		 e.printStackTrace();
//	    	 }
//	    	 break;
//	     case "/notice.ad":
//	    	 try {
//	    		 forward = new ActionForward();
//	    		 forward.setRedirect(false);
//	    		 forward.setPath("/app/admin/admin_notice.jsp");
//	    	 } catch (Exception e) {
//	    		 e.printStackTrace();
//	    	 }
//	    	 break;
//	     case "/findAnimal.ad":
//	    	 try {
//	    		 forward = new ActionForward();
//	    		 forward.setRedirect(false);
//	    		 forward.setPath("/app/admin/admin_findAnimal.jsp");
//	    	 } catch (Exception e) {
//	    		 e.printStackTrace();
//	    	 }
//	    	 break;
	     case "/popup.ad":
	    	 try {
	    		 forward = new ActionForward();
	    		 forward.setRedirect(false);
	    		 forward.setPath("/app/admin/admin_popup.jsp");
	    	 } catch (Exception e) {
	    		 e.printStackTrace();
	    	 }
	    	 break;
	     case "/AdminLogoutOk.ad":
	    	 try {
				forward = new AdminAction().execute(req, resp, "AdminLogoutOk");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	 break;
	     case "/AdminLogin.ad":
	    	 try {
				forward = new ActionForward();
				 forward.setRedirect(false);
				 forward.setPath("/app/admin/admin_login.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	 break;
	     case "/adminBoardFileUpload.ad" :
				try {
					forward = new AdminAction().execute(req, resp, "adminBoardFileUpload");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "/adminInsertBoardContents.ad" :
				try {
					forward = new AdminAction().execute(req, resp, "adminBoardWriteOkAction");
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "/adminBoardFileForceDelete.ad" :
				try {
					forward = new AdminAction().execute(req, resp, "adminBoardFileForceDelete");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
		default:
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.html");
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
