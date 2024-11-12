package com.example.potholedectection.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.potholedectection.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class Dashboard_Fragment extends Fragment {

    private View view;
    private BarChart barChart;
    private LineChart lineChart;
    private PieChart pieChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment_dashboard, container, false);

        barChart = view.findViewById(R.id.barChart);
        pieChart = view.findViewById(R.id.pieChart);
        lineChart = view.findViewById(R.id.lineChart);

        // Gọi các phương thức thiết lập biểu đồ
        setupPieChart();
        setupLineChart();
        setupBarChart();

        return view;
    }

    private void setupPieChart() {
        // Tạo danh sách các mục cho biểu đồ
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40f, "Category A"));
        entries.add(new PieEntry(30f, "Category B"));
        entries.add(new PieEntry(20f, "Category C"));

        // Tạo một PieDataSet từ danh sách các mục
        PieDataSet dataSet = new PieDataSet(entries, "Categories");
        dataSet.setColors(new int[]{Color.RED, Color.GREEN, Color.YELLOW}); // Màu sắc cho từng mục
        dataSet.setValueTextColor(Color.WHITE); // Màu chữ cho giá trị
        dataSet.setValueTextSize(16f); // Kích thước chữ cho giá trị

        // Tạo PieData từ PieDataSet
        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.invalidate(); // Cập nhật biểu đồ
    }

    private void setupLineChart() {
        // Tạo danh sách các điểm dữ liệu cho biểu đồ
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 1));
        entries.add(new Entry(1, 3));
        entries.add(new Entry(2, 2));
        entries.add(new Entry(3, 5));
        entries.add(new Entry(4, 4));

        // Tạo một LineDataSet từ danh sách các điểm
        LineDataSet dataSet = new LineDataSet(entries, "Data Set 1");
        dataSet.setColor(Color.BLUE); // Màu đường
        dataSet.setValueTextColor(Color.BLACK); // Màu chữ cho giá trị
        dataSet.setValueTextSize(12f); // Kích thước chữ cho giá trị
        dataSet.setLineWidth(2f); // Độ dày của đường
        dataSet.setCircleColor(Color.RED); // Màu của các điểm trên đường
        dataSet.setCircleRadius(4f); // Kích thước của các điểm

        // Tạo LineData từ LineDataSet
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); // Cập nhật biểu đồ
    }

    private void setupBarChart() {
        // Tạo dữ liệu cho biểu đồ
        ArrayList<BarEntry> entries1 = new ArrayList<>();
        ArrayList<BarEntry> entries2 = new ArrayList<>();
        ArrayList<BarEntry> entries3 = new ArrayList<>();

        // Thêm dữ liệu cho từng ngày (7 ngày)
        for (int i = 0; i < 7; i++) {
            entries1.add(new BarEntry(i, (float) (Math.random() * 10)));
            entries2.add(new BarEntry(i, (float) (Math.random() * 10)));
            entries3.add(new BarEntry(i, (float) (Math.random() * 10)));
        }

        // Tạo 3 DataSet với 3 màu khác nhau
        BarDataSet set1 = new BarDataSet(entries1, "Level 1");
        set1.setColor(Color.rgb(0, 100, 0));

        BarDataSet set2 = new BarDataSet(entries2, "Level 2");
        set2.setColor(Color.rgb(0, 0, 100));

        BarDataSet set3 = new BarDataSet(entries3, "Level 3");
        set3.setColor(Color.rgb(100, 0, 0));

        // Gộp các DataSet vào BarData
        BarData data = new BarData(set1, set2, set3);

        // Thiết lập độ rộng của cột và khoảng cách
        float groupSpace = 0.2f; // Khoảng cách giữa các nhóm
        float barSpace = 0.02f; // Khoảng cách giữa các cột trong nhóm
        float barWidth = 0.25f; // Độ rộng của mỗi cột

        // Thiết lập các thuộc tính cho data
        data.setBarWidth(barWidth);

        // Thiết lập biểu đồ
        barChart.setData(data);
        barChart.groupBars(0, groupSpace, barSpace);

        // Tạo nhãn cho trục x
        String[] labels = new String[]{"T2", "T3", "T4", "T5", "T6", "T7", "CN"};

        // Cấu hình trục x
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setCenterAxisLabels(true);

        // Cấu hình trục y bên trái
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);

        // Ẩn trục y bên phải
        barChart.getAxisRight().setEnabled(false);

        // Các cấu hình khác
        barChart.getDescription().setEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setHighlightPerTapEnabled(true);

        // Tính toán khoảng giá trị x để hiển thị đầy đủ
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0 + barChart.getData().getGroupWidth(groupSpace, barSpace) * 7);

        // Thêm animation
        barChart.animateY(1000);

        // Legend (chú thích)
        Legend legend = barChart.getLegend();
        legend.setEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER); // Căn giữa theo chiều dọc
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT); // Đặt bên phải
        legend.setOrientation(Legend.LegendOrientation.VERTICAL); // Sắp xếp theo chiều dọc
        legend.setDrawInside(false); // Vẽ bên ngoài biểu đồ
        legend.setYOffset(0f); // Điều chỉnh khoảng cách theo chiều dọc
        legend.setXOffset(10f); // Điều chỉnh khoảng cách với mép phải
        legend.setTextSize(12f); // Kích thước chữ
        legend.setForm(Legend.LegendForm.SQUARE); // Hình dạng ký hiệu (có thể là SQUARE, CIRCLE, LINE)
        legend.setFormSize(12f); // Kích thước ký hiệu
        legend.setFormToTextSpace(5f); // Khoảng cách giữa ký hiệu và text

        // Refresh biểu đồ
        barChart.invalidate();
    }
}
