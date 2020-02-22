package statistics;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;

import dao.DownloadListDAO;

@Named
@RequestScoped
public class ChartBB {
	private LineChartModel model = new LineChartModel();

	@Inject
	DownloadListDAO dListDAO;

	@PostConstruct
	public void init() {
		getDownloadedFilesChart();
	}
	
	public void getDownloadedFilesChart() {
		ChartData data = new ChartData();

        LineChartDataSet dataSet = new LineChartDataSet();
        List<Number> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();
		
        for(int i = 0; i < 12; i++) {
			LocalDate date = YearMonth.now().minusMonths( i ).atEndOfMonth();
			values.add(dListDAO.countInDate(date.getMonthValue(), date.getYear()));
			labels.add(date.getMonthValue() + "-" + date.getYear());
		}
        
        Collections.reverse(values);
        Collections.reverse(labels);
        
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("Pobrane pliki");
        dataSet.setBorderColor("#0AC59D");
        dataSet.setLineTension(0.1);
        data.addChartDataSet(dataSet);
        data.setLabels(labels);
        model.setData(data);
		
	}

	
	public void getDownloadedPackagesChart() {
		
	}

	public LineChartModel getModel() {
		return model;
	}

	public void setModel(LineChartModel model) {
		this.model = model;
	}

}
