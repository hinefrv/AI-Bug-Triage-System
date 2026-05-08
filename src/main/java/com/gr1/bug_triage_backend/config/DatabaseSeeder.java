package com.gr1.bug_triage_backend.config;

import com.gr1.bug_triage_backend.entity.Category;
import com.gr1.bug_triage_backend.entity.Developer;
import com.gr1.bug_triage_backend.repository.CategoryRepository;
import com.gr1.bug_triage_backend.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public void run(String... args) throws Exception {
        // 1. Kiểm tra nếu bảng Category trống thì mới thêm vào (tránh bị trùng lặp khi chạy lại)
        if (categoryRepository.count() == 0) {
            System.out.println("Đang nạp dữ liệu Category mẫu...");
            Category cat1 = new Category(null, "Database Error", "Lỗi liên quan đến truy vấn SQL, kết nối DB", null);
            Category cat2 = new Category(null, "UI/UX Glitch", "Lỗi hiển thị giao diện, CSS, vỡ layout", null);
            Category cat3 = new Category(null, "Security Vulnerability", "Lỗi bảo mật, rò rỉ dữ liệu, xác thực", null);
            categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        }

        // 2. Nạp dữ liệu Lập trình viên mẫu
        if (developerRepository.count() == 0) {
            System.out.println("Đang nạp dữ liệu Developer mẫu...");
            Developer dev1 = new Developer(null, "Phạm Hiển", "hien.pham@hust.edu.vn", 0, null, null);
            Developer dev2 = new Developer(null, "Nguyễn Hương", "huong.nguyen@hust.edu.vn", 0, null, null);
            Developer dev3 = new Developer(null, "Lê Hiếu", "hieu.le@hust.edu.vn", 0, null, null);
            developerRepository.saveAll(Arrays.asList(dev1, dev2, dev3));
        }

        System.out.println("Quá trình nạp dữ liệu nền (Master Data) hoàn tất!");
    }
}