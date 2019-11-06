package com.gmail.mosoft521.cp.jxc.controller;

import com.gmail.mosoft521.cp.jxc.entity.Purchase;
import com.gmail.mosoft521.cp.jxc.service.EmpService;
import com.gmail.mosoft521.cp.jxc.service.ProductService;
import com.gmail.mosoft521.cp.jxc.service.ProviderService;
import com.gmail.mosoft521.cp.jxc.service.PurchaseService;
import com.gmail.mosoft521.cp.jxc.vo.PurchaseVO;
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
@RequestMapping("/purchase")
public class PurchaseController {

    //日期格式
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //时间格式
    private SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private EmpService empService;

    @Autowired
    private ProductService productService;

    /**
     * 获取所有采购列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<PurchaseVO> list() {
        List<Purchase> purchaseList = purchaseService.list();
        List<PurchaseVO> purchaseVOList = new ArrayList<>(purchaseList.size());
        for (Purchase purchase : purchaseList) {
            PurchaseVO purchaseVO = new PurchaseVO();
            BeanUtils.copyProperties(purchase, purchaseVO);
            purchaseVO.setProviderName(providerService.getNameById(purchaseVO.getProviderId()));
            purchaseVO.setEmpName(empService.getNameById(purchaseVO.getEmpId()));
            purchaseVO.setProductName(productService.getNameById(purchaseVO.getProductId()));
            purchaseVOList.add(purchaseVO);
        }
        return purchaseVOList;
    }

    /**
     * 保存或修改采购
     *
     * @return
     */
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public boolean saveOrUpdate(@RequestParam Integer purchaseId, @RequestParam String purchaseNo,@RequestParam Integer providerId, @RequestParam Integer empId, @RequestParam Integer productId,
                                @RequestParam String day, @RequestParam Float price, @RequestParam Integer quantity, @RequestParam String remark) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(purchaseId);
        purchase.setPurchaseNo(purchaseNo);
        purchase.setProviderId(providerId);
        purchase.setEmpId(empId);
        purchase.setProductId(productId);
        Date d = null;
        try {
            d = timeFormat.parse(day);
        } catch (ParseException e) {
            return false;
        }
        purchase.setDay(d);
        purchase.setPrice(price);
        purchase.setQuantity(quantity);
        purchase.setRemark(remark);
        return purchaseService.saveOrUpdate(purchase);
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam Integer purchaseId) {
        return purchaseService.delete(purchaseId);
    }
}
