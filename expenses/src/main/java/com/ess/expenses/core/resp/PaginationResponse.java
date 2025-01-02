package com.ess.expenses.core.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse<T>  {
        private int currentPage;
        private int totalPages;
        private long totalItems;
        private int pageSize;
        private List<T> data = new ArrayList<>();
}
