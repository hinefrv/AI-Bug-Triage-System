package com.gr1.bug_triage_backend.controller;

import com.gr1.bug_triage_backend.entity.BugReport;
import com.gr1.bug_triage_backend.service.BugReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bugs")
@CrossOrigin(origins = "*") // Cho phép các hệ thống khác (như React, Python) gọi API
public class BugReportController {

    @Autowired
    private BugReportService bugService;

    // API 1: Xem danh sách lỗi (GET /api/v1/bugs)
    @GetMapping
    public ResponseEntity<List<BugReport>> getAllBugs() {
        return ResponseEntity.ok(bugService.getAllBugs());
    }

    // API 2: Gửi lỗi mới vào hệ thống (POST /api/v1/bugs)
    @PostMapping
    public ResponseEntity<BugReport> createBug(@RequestBody BugReport bugReport) {
        BugReport savedBug = bugService.saveBug(bugReport);
        return ResponseEntity.ok(savedBug);
    }
}