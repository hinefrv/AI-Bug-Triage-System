package com.gr1.bug_triage_backend.entity;

import com.gr1.bug_triage_backend.entity.Category;
import com.gr1.bug_triage_backend.entity.Incident;
import com.gr1.bug_triage_backend.entity.Source;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bug_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BugReport {
    // Vì ID từ GitHub dạng chuỗi (VD: GH-1234), ta dùng String làm ID
    @Id
    private String bugID;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String rawText;

    @Column(columnDefinition = "TEXT")
    private String stackTrace;

    private String severityLabel;
    private String status;

    // --- MỐI QUAN HỆ KHÓA NGOẠI (FOREIGN KEYS) ---

    // N Lỗi thuộc về 1 Nguồn (GitHub, Jira...)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    private Source source;

    // N Lỗi thuộc về 1 Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // N Lỗi bị gom vào 1 Incident
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incident_id")
    private Incident incident;
}