package com.gr1.bug_triage_backend.service;

import com.gr1.bug_triage_backend.entity.BugReport;
import com.gr1.bug_triage_backend.repository.BugReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugReportService {

    @Autowired
    private BugReportRepository bugRepository;

    // Hàm lấy danh sách toàn bộ Bug
    public List<BugReport> getAllBugs() {
        return bugRepository.findAll();
    }

    // Hàm nhận Bug mới và lưu vào DB
    public BugReport saveBug(BugReport bugReport) {
        // Tạm thời lưu thẳng, sẽ chèn code gọi AI ở bước này
        return bugRepository.save(bugReport);
    }
}