package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Lấy tên tệp tin từ tham số yêu cầu
		String fileName = request.getSession().getAttribute("fileName") + "";

		if (fileName != null && !fileName.isEmpty()) {
			// Đường dẫn đầy đủ của tệp tin tải xuống
			// Đường dẫn của file kết quả sau khi nhận diện
			String filePath = request.getSession().getAttribute("filePath") + "";

			// Thiết lập các thông số phản hồi
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // phản hồi tải
																									// xuống

			// Mở luồng đọc từ tệp tin để chuẩn bị cho việc tải xuống
			FileInputStream fis = new FileInputStream(filePath);

			// Luồng ghi để gửi dữ liệu tải xuống đến người dùng
			OutputStream os = response.getOutputStream();

			// Đọc dữ liệu từ tệp tin và ghi vào luồng đầu ra

			int bytesRead;
			// Tạo một bộ đệm để đọc dữ liệu từ tệp tin
			byte[] buffer = new byte[4096];
			while ((bytesRead = fis.read(buffer)) != -1) {
				os.write(buffer);
			}

			// Đóng luồng
			fis.close();
			os.close();
//		            
		} else {
			// Xử lý lỗi nếu không có tệp tin được yêu cầu
//		            response.getWriter().println("Không tìm thấy tệp tin để tải xuống.");
		}

		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
