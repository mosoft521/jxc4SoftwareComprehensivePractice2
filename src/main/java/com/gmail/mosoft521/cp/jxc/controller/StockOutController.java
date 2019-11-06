package com.gmail.mosoft521.cp.jxc.controller;

import com.gmail.mosoft521.cp.jxc.entity.Sale;
import com.gmail.mosoft521.cp.jxc.entity.StockOut;
import com.gmail.mosoft521.cp.jxc.service.CustomerService;
import com.gmail.mosoft521.cp.jxc.service.EmpService;
import com.gmail.mosoft521.cp.jxc.service.ProductService;
import com.gmail.mosoft521.cp.jxc.service.SaleService;
import com.gmail.mosoft521.cp.jxc.service.StockOutService;
import com.gmail.mosoft521.cp.jxc.vo.StockOutVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/stockOut")
public class StockOutController {

    //日期格式
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //时间格式
    private SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private StockOutService stockOutService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmpService empService;

    @Autowired
    private ProductService productService;

    /**
     * 获取所有出库列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<StockOutVO> list() {
        List<StockOut> stockOutList = stockOutService.list();
        List<StockOutVO> stockOutVOList = new ArrayList<>(stockOutList.size());
        for (StockOut stockOut : stockOutList) {
            StockOutVO stockOutVO = new StockOutVO();
            BeanUtils.copyProperties(stockOut, stockOutVO);
            stockOutVO.setSaleNo(saleService.getNoById(stockOut.getSaleId()));
            Sale sale = saleService.getById(stockOut.getSaleId());
            stockOutVO.setCustomerName(customerService.getNameById(sale.getCustomerId()));
            stockOutVO.setEmpName(empService.getNameById(sale.getEmpId()));
            stockOutVO.setProductName(productService.getNameById(sale.getProductId()));
            stockOutVOList.add(stockOutVO);
        }
        return stockOutVOList;
    }

    /**
     * 保存或修改出库
     *
     * @return
     */
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public boolean saveOrUpdate(@RequestParam Integer stockOutId, @RequestParam String stockOutNo, @RequestParam Integer saleId, @RequestParam String strDay, @RequestParam Integer quantity, @RequestParam String remark) {
        StockOut stockOut = new StockOut();
        stockOut.setStockOutId(stockOutId);
        stockOut.setStockOutNo(stockOutNo);
        stockOut.setSaleId(saleId);
        Date d = null;
        try {
            d = timeFormat.parse(strDay);
        } catch (ParseException e) {
            return false;
        }
        stockOut.setDay(d);
        stockOut.setQuantity(quantity);
        stockOut.setRemark(remark);
        return stockOutService.saveOrUpdate(stockOut);
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam Integer stockOutId) {
        return stockOutService.delete(stockOutId);
    }
}
