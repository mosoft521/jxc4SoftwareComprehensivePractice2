package com.gmail.mosoft521.cp.jxc.controller;

import com.gmail.mosoft521.cp.jxc.entity.Purchase;
import com.gmail.mosoft521.cp.jxc.entity.StockIn;
import com.gmail.mosoft521.cp.jxc.service.EmpService;
import com.gmail.mosoft521.cp.jxc.service.ProductService;
import com.gmail.mosoft521.cp.jxc.service.ProviderService;
import com.gmail.mosoft521.cp.jxc.service.PurchaseService;
import com.gmail.mosoft521.cp.jxc.service.StockInService;
import com.gmail.mosoft521.cp.jxc.vo.PurchaseVO;
import com.gmail.mosoft521.cp.jxc.vo.StockInVO;
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
@RequestMapping("/stockIn")
public class StockInController {

    //日期格式
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //时间格式
    private SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private StockInService stockInService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private EmpService empService;

    @Autowired
    private ProductService productService;

    /**
     * 获取所有入库列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<StockInVO> list() {
        List<StockIn> stockInList = stockInService.list();
        List<StockInVO> stockInVOList = new ArrayList<>(stockInList.size());
        for (StockIn stockIn : stockInList) {
            StockInVO stockInVO = new StockInVO();
            BeanUtils.copyProperties(stockIn, stockInVO);
            stockInVO.setPurchaseNo(purchaseService.getNoById(stockIn.getPurchaseId()));
            Purchase purchase = purchaseService.getById(stockIn.getPurchaseId());
            stockInVO.setProviderName(providerService.getNameById(purchase.getProviderId()));
            stockInVO.setEmpName(empService.getNameById(purchase.getEmpId()));
            stockInVO.setProductName(productService.getNameById(purchase.getProductId()));
            stockInVOList.add(stockInVO);
        }
        return stockInVOList;
    }

    /**
     * 保存或修改入库
     *
     * @return
     */
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public boolean saveOrUpdate(@RequestParam Integer stockInId, @RequestParam String stockInNo, @RequestParam Integer purchaseId, @RequestParam String strDay, @RequestParam Integer quantity, @RequestParam String remark) {
        StockIn stockIn = new StockIn();
        stockIn.setStockInId(stockInId);
        stockIn.setStockInNo(stockInNo);
        stockIn.setPurchaseId(purchaseId);
        Date d = null;
        try {
            d = timeFormat.parse(strDay);
        } catch (ParseException e) {
            return false;
        }
        stockIn.setDay(d);
        stockIn.setQuantity(quantity);
        stockIn.setRemark(remark);
        return stockInService.saveOrUpdate(stockIn);
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam Integer stockInId) {
        return stockInService.delete(stockInId);
    }
}
