package com.mycompany.View;

import com.mycompany.Domainmodels.DichVu;
import com.mycompany.Domainmodels.DichVuDung;
import com.mycompany.Domainmodels.HoaDon;
import com.mycompany.Domainmodels.KhachHang;
import com.mycompany.Domainmodels.NguoiDung;
import com.mycompany.Domainmodels.Phong;
import com.mycompany.Domainmodels.ThongTinThuePhong;
import com.mycompany.Service.DichVuDungService;
import com.mycompany.Service.DichVuService;
import com.mycompany.Service.KhachHangService;
import com.mycompany.Service.NhanVienInterface;
import com.mycompany.Service.PhongService;
import com.mycompany.Service.ThongKeService;
import com.mycompany.Service.ThongTinThuePhongInterface;
import com.mycompany.Service.impl.DichVuDungServiceImp;
import com.mycompany.Service.impl.DichVuImpl;
import com.mycompany.Service.impl.HoaDonimpl;
import com.mycompany.Service.impl.KhachHangImp;
import com.mycompany.Service.impl.NhanVienimpl;
import com.mycompany.Service.impl.PhongServiceimpl;

import com.mycompany.Service.impl.ThongKeServiceImpl;
import com.mycompany.Service.impl.ThongTinThuePhongImpl;
import com.mycompany.ViewModels.ThongKeView;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.Domainmodels.PhanQuyen;
import com.mycompany.Domainmodels.ThongTinHoaDon;
import com.mycompany.Service.HoaDonService;
import com.mycompany.Service.HoaDonViewService;
import com.mycompany.Service.impl.HoaDonViewServiceImpl;
import javax.swing.JTextPane;

public class QLKS extends javax.swing.JFrame {

    private KhachHangService ks = new KhachHangImp();
    private ThongTinThuePhongInterface ti = new ThongTinThuePhongImpl();
    private PhongService phongService = new PhongServiceimpl();
    private DichVuService dichVuService = new DichVuImpl();
    private DichVuDungService dichVuDungService = new DichVuDungServiceImp();
    private NhanVienInterface nhanVienService = new NhanVienimpl();
    private ThongKeService thongKeService = new ThongKeServiceImpl();
    private HoaDonService hoadonservice = new HoaDonimpl();
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcm;
    private NumberFormat numberFM = new DecimalFormat();
    private HoaDonViewService hoaDonViewService = new HoaDonViewServiceImpl();

    public QLKS() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadKhachHang(ks.Getlist());
        loadNhanVien(nhanVienService.getAll());
        DatTra.setSize(1200, 800);
        ThanhToanJframe.setSize(1120, 770);

        loadCBBNam();
        loadCBBNgay();
        loadCBBThang();
        loadHomePage();
        loadTabledichvu();
        loadPhong(phongService.getAll());
        loadCBBDichVu(dichVuService.getAll());
        loadHoaDonView(hoaDonViewService.getAll());
        //setICon
        Icon trangChu = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\house.png");
        this.btnTrangCHu.setIcon(trangChu);
        Icon logo = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\hotel.png");
        this.LoGo.setIcon(logo);
        Icon PhongIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\living-room.png");
        this.btnPhong.setIcon(PhongIcon);
        Icon KhachHangIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\team.png");
        this.btnKhachHang.setIcon(KhachHangIcon);
        Icon NhanVienIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\manager.png");
        this.btnNhanVien.setIcon(NhanVienIcon);
        Icon thanhToanIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\pay.png");
        this.btnThanhToanđaoien.setIcon(thanhToanIcon);
        Icon dichVuIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\service.png");
        this.btnDIchVu.setIcon(dichVuIcon);
        Icon thongkeIcon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\analysis.png");
        this.btnThongKedaodien.setIcon(thongkeIcon);
        Icon inhoadon = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\printer.png");
        this.btnInhoaDon.setIcon(inhoadon);
        Icon cancelIn = new ImageIcon("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\close.png");
        this.btnHuyInHd.setIcon(cancelIn);
    }

    private void loadCBBNgay() {
        cbbNgay.addItem("");
        for (int i = 1; i <= 31; i++) {
            cbbNgay.addItem("" + i);
        }
    }

    private void loadCBBThang() {
        cbbThang.addItem("");
        for (int i = 1; i <= 12; i++) {
            cbbThang.addItem("" + i);
        }
    }

    private void loadCBBNam() {
        int year = new java.util.Date().getYear() + 1900;
        for (int i = 0; i <= (year - 2022); i++) {
            cbbNam.addItem("" + (2022 + i));
        }
    }

    private void showThongKe(List<ThongKeView> listTK) {
        dtm = (DefaultTableModel) tblThongKe.getModel();
        dtm.setRowCount(0);

        for (ThongKeView t : listTK) {
            dtm.addRow(new Object[]{
                t.getNgay(), t.getSoHoaDon(), numberFM.format(t.getTongTien())
            });
        }
    }

    public void loadKhachHang(List<KhachHang> listkh) {

        DefaultTableModel defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < listkh.size(); i++) {
            Object[] RowData = {
                i + 1,
                listkh.get(i).getMa(),
                listkh.get(i).getHoVaTen(),
                listkh.get(i).getNgaySinh(),
                listkh.get(i).getGioiTinh(),
                listkh.get(i).getsCCCD(),
                listkh.get(i).getsDT(),
                listkh.get(i).getDiaChi()
            };
            defaultTableModel.addRow(RowData);
        }
    }

    public void loadPhong(List<Phong> listkh) {

        DefaultTableModel defaultTableModel = (DefaultTableModel) tblPhong.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < listkh.size(); i++) {
            Object[] RowData = {
                i + 1,
                listkh.get(i).getMaPhong(),
                listkh.get(i).getTenPhong(),
                listkh.get(i).getTang(),
                listkh.get(i).getLoaiPhong(),
                listkh.get(i).getGiaTheoGio(),
                listkh.get(i).getGiaTheoNgay(),
                listkh.get(i).getSoNguoiToiDa(),
                listkh.get(i).TrangThaiPhong()
            };
            defaultTableModel.addRow(RowData);
        }
    }

    public void loadNhanVien(List<NguoiDung> listnv) {

        DefaultTableModel defaultTableModel = (DefaultTableModel) tblnhanvien.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < listnv.size(); i++) {
            Object[] RowData = {
                i + 1,
                listnv.get(i).getMa(),
                listnv.get(i).getHoVaTen(),
                listnv.get(i).getNgaySinh(),
                listnv.get(i).getGioiTinh(),
                listnv.get(i).getcCCD(),
                listnv.get(i).getSdt(),
                listnv.get(i).getDiaChi(),
                listnv.get(i).getEmail(),
                listnv.get(i).getPassWord()
            };
            defaultTableModel.addRow(RowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        DatTra = new javax.swing.JFrame();
        DatTraPhong = new javax.swing.JPanel();
        pnKH = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtSoNguoi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtTGTra = new com.toedter.calendar.JDateChooser();
        cbbTenPhong = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        cbbHinhThucThue = new javax.swing.JComboBox<>();
        txtSearchKH = new javax.swing.JTextField();
        btnTimKiemKH = new javax.swing.JButton();
        txtTGThue = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbKH = new javax.swing.JTable();
        lblTenP = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHodDonCTDVD = new javax.swing.JTable();
        btnXoaDV1 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        cbbDV = new javax.swing.JComboBox<>();
        btnThemDVD = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        txtTGThemDVD = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbTTThuePhong = new javax.swing.JTable();
        btnLuu = new javax.swing.JButton();
        btnCheckIn1 = new javax.swing.JButton();
        btnTraPhong = new javax.swing.JButton();
        ThanhToanJframe = new javax.swing.JFrame();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txtNgayCheckinTT = new javax.swing.JTextField();
        txtTenKHTT = new javax.swing.JTextField();
        txtSDTTT = new javax.swing.JTextField();
        txtDiaChiTT = new javax.swing.JTextField();
        cbbGioiTinhTT = new javax.swing.JComboBox<>();
        txtNgaySinhTT = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        txtNgayCheckOutTT = new javax.swing.JTextField();
        cbbHinhThucThueTT = new javax.swing.JComboBox<>();
        jLabel103 = new javax.swing.JLabel();
        txtSoCCCDTT = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTTThuePhongTT = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtTenPhongTT = new javax.swing.JTextField();
        txtTangTT = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbTTDVDTT = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        txtTienPhong = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txtTongphiDV = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTgThue = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtTongTienPhong = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        txtTienThanhToan = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        btnInhoaDon = new javax.swing.JButton();
        btnHuyInHd = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LoGo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        MHCHinh = new javax.swing.JPanel();
        Trangchu = new javax.swing.JPanel();
        Phong = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        txtmaphong = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        txttenPhong = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        txtTang = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        txtgiatheogio = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        txtgiatheongay = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        txtsonguoitoida = new javax.swing.JTextField();
        btnclearPhong = new javax.swing.JButton();
        btnxoaPhong = new javax.swing.JButton();
        btnsuaPhong = new javax.swing.JButton();
        btnluuPhong = new javax.swing.JButton();
        txtLoaiPhong = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        KhachHang = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txttenkh = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtngaysinhkh = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        rdNukh = new javax.swing.JRadioButton();
        rdoNamkh = new javax.swing.JRadioButton();
        jLabel87 = new javax.swing.JLabel();
        txtcccd = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        btnclearKh = new javax.swing.JButton();
        btnSuakh = new javax.swing.JButton();
        btnluukh = new javax.swing.JButton();
        txtTimKiemKhachHang = new javax.swing.JTextField();
        btnTimKiemKhachHanng = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        ThanhToan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txttenkhTT = new javax.swing.JTextField();
        txttenphongTT = new javax.swing.JTextField();
        txtmahdTT = new javax.swing.JTextField();
        txttangTT = new javax.swing.JTextField();
        txttiendua = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txttienthua = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txttongtienTT = new javax.swing.JTextField();
        btnthanhtoan = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDOn = new javax.swing.JTable();
        DichVu = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        txtTenDV = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSuaDV = new javax.swing.JButton();
        btnXoaDV = new javax.swing.JButton();
        btnThemDV = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDV = new javax.swing.JTable();
        NhanVien = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtngaysinhnv = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        rdonunv = new javax.swing.JRadioButton();
        rdonvnam = new javax.swing.JRadioButton();
        jLabel97 = new javax.swing.JLabel();
        txtcccdnv = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        txtsdtnv = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        txtDiachinv = new javax.swing.JTextField();
        btnclearnv = new javax.swing.JButton();
        btnxoanv = new javax.swing.JButton();
        btnsuanv = new javax.swing.JButton();
        btnluunv = new javax.swing.JButton();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtpass = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblnhanvien = new javax.swing.JTable();
        ThongKe = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtdoanhthungay = new javax.swing.JTextField();
        txtsohoadonngay = new javax.swing.JTextField();
        txtDoanhThuTongNgay = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txtdoanhthuThang = new javax.swing.JTextField();
        txtSoHoaDonThang = new javax.swing.JTextField();
        txtDoanhThuTongThang = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        txtdoanhthuNam = new javax.swing.JTextField();
        txtSoHoaDonNam = new javax.swing.JTextField();
        txtDoanhThuTongNam = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        cbbNgay = new javax.swing.JComboBox<>();
        jLabel107 = new javax.swing.JLabel();
        cbbThang = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        cbbNam = new javax.swing.JComboBox<>();
        btnThongKe1 = new javax.swing.JButton();
        Menu = new javax.swing.JPanel();
        btnTrangCHu = new javax.swing.JButton();
        btnPhong = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnThanhToanđaoien = new javax.swing.JButton();
        btnDIchVu = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnThongKedaodien = new javax.swing.JButton();
        Dangxuat = new javax.swing.JButton();

        DatTra.setResizable(false);

        DatTraPhong.setBackground(new java.awt.Color(204, 255, 255));
        DatTraPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đặt, trả phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        pnKH.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));
        pnKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnKHMouseClicked(evt);
            }
        });

        jLabel54.setText("Thời gian trả");

        jLabel53.setText("Thời gian thuê");

        jLabel55.setText("Số người");

        txtSoNguoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNguoiActionPerformed(evt);
            }
        });

        jLabel7.setText("Tên phòng");

        lblID.setForeground(new java.awt.Color(240, 240, 240));
        lblID.setText("....");

        cbbTenPhong.setEnabled(false);
        cbbTenPhong.setInheritsPopupMenu(true);

        jLabel36.setText("Hình thức thuê:");

        cbbHinhThucThue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thue theo gio", "Thue theo ngay" }));

        btnTimKiemKH.setText("Tìm kiếm KH");
        btnTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKHActionPerformed(evt);
            }
        });

        tbKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã KH", "Tên KH", "Ngày Sinh", "Giới tính", "CCCD", "SDT", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbKH);

        lblTenP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenP.setForeground(new java.awt.Color(255, 51, 51));
        lblTenP.setText("jLabel2");

        javax.swing.GroupLayout pnKHLayout = new javax.swing.GroupLayout(pnKH);
        pnKH.setLayout(pnKHLayout);
        pnKHLayout.setHorizontalGroup(
            pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKHLayout.createSequentialGroup()
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKHLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtSearchKH, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnTimKiemKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTenP)
                        .addGap(6, 6, 6)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKHLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jLabel36)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbHinhThucThue, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTGTra, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTGThue, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSoNguoi, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbbTenPhong, javax.swing.GroupLayout.Alignment.LEADING, 0, 100, Short.MAX_VALUE)))
                .addGap(63, 63, 63))
        );
        pnKHLayout.setVerticalGroup(
            pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKHLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(cbbHinhThucThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53)
                            .addComponent(txtTGThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(txtTGTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbbTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnKHLayout.createSequentialGroup()
                        .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearchKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTimKiemKH)
                                .addComponent(lblTenP))
                            .addGroup(pnKHLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblID)))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Dịch vụ dùng"));

        tbHodDonCTDVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Phòng", "Tên DV", "Số lượng dùng", "Thời gian gọi", "Phí dịch vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbHodDonCTDVD);

        btnXoaDV1.setText("Xóa dịch vụ");
        btnXoaDV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDV1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(btnXoaDV1)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaDV1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Các dịch vụ của phòng"));

        cbbDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbDVMouseClicked(evt);
            }
        });

        btnThemDVD.setText("Thêm dịch vụ");
        btnThemDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDVDActionPerformed(evt);
            }
        });

        jLabel51.setText("Thời gian:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel51)
                .addGap(18, 18, 18)
                .addComponent(txtTGThemDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(cbbDV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnThemDVD)
                .addGap(63, 63, 63))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDVD)
                    .addComponent(cbbDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtTGThemDVD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin thuê phòng"));

        tbTTThuePhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tầng", "Số phòng", "Tên KH", "Hình thức thuê", "Thời gian thuê", "Thời gian trả", "Số người"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTTThuePhong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbTTThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTTThuePhongMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbTTThuePhong);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnCheckIn1.setText("Hủy");
        btnCheckIn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckIn1ActionPerformed(evt);
            }
        });

        btnTraPhong.setText("Trả phòng");
        btnTraPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DatTraPhongLayout = new javax.swing.GroupLayout(DatTraPhong);
        DatTraPhong.setLayout(DatTraPhongLayout);
        DatTraPhongLayout.setHorizontalGroup(
            DatTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatTraPhongLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(DatTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DatTraPhongLayout.createSequentialGroup()
                        .addComponent(btnLuu)
                        .addGap(38, 38, 38)
                        .addComponent(btnTraPhong)
                        .addGap(31, 31, 31)
                        .addComponent(btnCheckIn1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DatTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(DatTraPhongLayout.createSequentialGroup()
                            .addComponent(jLabel52)
                            .addGap(1054, 1054, 1054))
                        .addGroup(DatTraPhongLayout.createSequentialGroup()
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(DatTraPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DatTraPhongLayout.setVerticalGroup(
            DatTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatTraPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DatTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DatTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnCheckIn1)
                    .addComponent(btnTraPhong))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout DatTraLayout = new javax.swing.GroupLayout(DatTra.getContentPane());
        DatTra.getContentPane().setLayout(DatTraLayout);
        DatTraLayout.setHorizontalGroup(
            DatTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DatTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DatTraLayout.setVerticalGroup(
            DatTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatTraLayout.createSequentialGroup()
                .addComponent(DatTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jPanel22.setBackground(new java.awt.Color(204, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel61.setText("Ngày checkin:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel62.setText("Tên khách hàng:");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel63.setText("Số điện thoại:");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setText("Quê quán/Địa chỉ:");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel65.setText("Giới tính:");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel66.setText("Ngày sinh:");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setText("Hình thức :");

        cbbGioiTinhTT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbbGioiTinhTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel102.setText("Ngày checkout:");

        cbbHinhThucThueTT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbbHinhThucThueTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thue theo ngay", "Thue theo gio" }));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel103.setText("Số CCCD:");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jLabel61)
                    .addComponent(jLabel64)
                    .addComponent(jLabel103))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiaChiTT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(txtSoCCCDTT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKHTT))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel65)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbGioiTinhTT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgaySinhTT)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(txtNgayCheckinTT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayCheckOutTT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbHinhThucThueTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txtNgayCheckinTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102)
                    .addComponent(txtNgayCheckOutTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(cbbHinhThucThueTT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txtTenKHTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbGioiTinhTT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(5, 5, 5)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jLabel64)
                    .addComponent(txtDiaChiTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinhTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoCCCDTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel103))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSDTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel63)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(204, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        tbTTThuePhongTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ngày checkin", "Ngày checkout", "Hình thức thuê", "Giá", "Thời gian ở", "Loại phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTTThuePhongTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTTThuePhongTTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTTThuePhongTT);

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setText("Số phòng:");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel69.setText("Tầng:");

        txtTenPhongTT.setEnabled(false);

        txtTangTT.setEnabled(false);

        tbTTDVDTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dịch vụ", "Thời gian gọi", "Tổng chi phí"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tbTTDVDTT);

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel71.setText("Tiền phòng:");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel72.setText("Tổng tiền DV:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setText("X");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setText("=");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel77.setText("Ghi chú:");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel71)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel77)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel19)
                                .addGap(81, 81, 81)
                                .addComponent(txtTgThue, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel23Layout.createSequentialGroup()
                                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel69)
                                        .addComponent(jLabel68))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenPhongTT, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                        .addComponent(txtTangTT))
                                    .addGap(33, 33, 33)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTongphiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(txtTenPhongTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel69)
                            .addComponent(txtTangTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel71)
                                    .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongTienPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtTgThue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(txtTongphiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel76.setText("Tổng tiền phải thanh toán:");

        btnInhoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnInhoaDon.setText("In hóa đơn");
        btnInhoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInhoaDonActionPerformed(evt);
            }
        });

        btnHuyInHd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnHuyInHd.setText("Hủy bỏ");
        btnHuyInHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyInHdActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("VNĐ");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                                .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(btnInhoaDon)
                                .addGap(174, 174, 174)
                                .addComponent(btnHuyInHd))))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel76)
                        .addGap(30, 30, 30)
                        .addComponent(txtTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(txtTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInhoaDon)
                            .addComponent(btnHuyInHd))
                        .addContainerGap())
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout ThanhToanJframeLayout = new javax.swing.GroupLayout(ThanhToanJframe.getContentPane());
        ThanhToanJframe.getContentPane().setLayout(ThanhToanJframeLayout);
        ThanhToanJframeLayout.setHorizontalGroup(
            ThanhToanJframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ThanhToanJframeLayout.setVerticalGroup(
            ThanhToanJframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThanhToanJframeLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("QUẢN LÍ KHÁCH SẠN");

        jSeparator1.setBackground(new java.awt.Color(153, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(153, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(153, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(153, 255, 255));

        jSeparator3.setBackground(new java.awt.Color(153, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(153, 255, 255));

        MHCHinh.setBackground(new java.awt.Color(255, 255, 255));
        MHCHinh.setLayout(new java.awt.CardLayout());

        Trangchu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout TrangchuLayout = new javax.swing.GroupLayout(Trangchu);
        Trangchu.setLayout(TrangchuLayout);
        TrangchuLayout.setHorizontalGroup(
            TrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1212, Short.MAX_VALUE)
        );
        TrangchuLayout.setVerticalGroup(
            TrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        MHCHinh.add(Trangchu, "card2");

        Phong.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel31.setText("QUẢN LÍ PHÒNG");

        jPanel25.setBackground(new java.awt.Color(204, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel90.setText("Mã phòng:");

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel91.setText("Tên phòng:");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel92.setText("Tầng:");

        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel93.setText("Loại phòng:");

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel94.setText("Giá theo giờ:");

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel95.setText("Giá theo ngày:");

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel96.setText("Số người tối đa:");

        btnclearPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnclearPhong.setText("Làm mới");

        btnxoaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoaPhong.setText("Xóa");
        btnxoaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaPhongActionPerformed(evt);
            }
        });

        btnsuaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsuaPhong.setText("Sửa");
        btnsuaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaPhongActionPerformed(evt);
            }
        });

        btnluuPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnluuPhong.setText("Lưu");
        btnluuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(txttenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel92)
                                    .addComponent(jLabel93)
                                    .addComponent(jLabel94)
                                    .addComponent(jLabel95)
                                    .addComponent(jLabel96))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnxoaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnclearPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTang, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(txtgiatheogio)
                            .addComponent(txtgiatheongay)
                            .addComponent(txtsonguoitoida)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnluuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsuaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                            .addComponent(txtLoaiPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addComponent(txtmaphong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(txttenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(txtTang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(txtgiatheogio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(txtgiatheongay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsonguoitoida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96))
                .addGap(51, 51, 51)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnclearPhong)
                    .addComponent(btnsuaPhong))
                .addGap(41, 41, 41)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoaPhong)
                    .addComponent(btnluuPhong))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Phòng", "Tên phòng", "Tầng", "Loại phòng", "Giá theo giờ", "Giá theo ngày", "Số người tối đa", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblPhong);

        javax.swing.GroupLayout PhongLayout = new javax.swing.GroupLayout(Phong);
        Phong.setLayout(PhongLayout);
        PhongLayout.setHorizontalGroup(
            PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhongLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PhongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        PhongLayout.setVerticalGroup(
            PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MHCHinh.add(Phong, "card3");

        KhachHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setText("QUẢN LÍ KHÁCH HÀNG");

        jPanel19.setBackground(new java.awt.Color(204, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Mã KH:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setText("Tên KH:");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setText("Ngày sinh:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setText("Giới tính:");

        buttonGroup1.add(rdNukh);
        rdNukh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdNukh.setText("Nữ");

        buttonGroup1.add(rdoNamkh);
        rdoNamkh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoNamkh.setSelected(true);
        rdoNamkh.setText("Nam");

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel87.setText("Số CCCD:");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel88.setText("Số ĐT:");

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel89.setText("Địa chỉ:");

        btnclearKh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnclearKh.setText("Làm mới");
        btnclearKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearKhActionPerformed(evt);
            }
        });

        btnSuakh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuakh.setText("Sửa");
        btnSuakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuakhActionPerformed(evt);
            }
        });

        btnluukh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnluukh.setText("Lưu");
        btnluukh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluukhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel87)
                                    .addComponent(jLabel88)
                                    .addComponent(jLabel89))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnclearKh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnluukh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addComponent(rdoNamkh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdNukh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44))
                                .addComponent(txtcccd, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                    .addComponent(btnSuakh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))))))
                .addGap(10, 10, 10))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(rdNukh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNamkh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(txtcccd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89))
                .addGap(51, 51, 51)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnclearKh)
                    .addComponent(btnSuakh))
                .addGap(65, 65, 65)
                .addComponent(btnluukh)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        btnTimKiemKhachHanng.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimKiemKhachHanng.setText("Tìm Kiếm");
        btnTimKiemKhachHanng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhachHanngActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã KH", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "SCCCD", "SĐT", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblKhachHang);

        javax.swing.GroupLayout KhachHangLayout = new javax.swing.GroupLayout(KhachHang);
        KhachHang.setLayout(KhachHangLayout);
        KhachHangLayout.setHorizontalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360))
            .addGroup(KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiemKhachHanng)
                        .addGap(65, 65, 65))
                    .addGroup(KhachHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))))
        );
        KhachHangLayout.setVerticalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(KhachHangLayout.createSequentialGroup()
                        .addGroup(KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiemKhachHang)
                            .addComponent(btnTimKiemKhachHanng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        MHCHinh.add(KhachHang, "card4");

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setText("Mã HĐ:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("Tầng");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setText("Tên KH");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setText("Tiền Khách Đưa");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setText("Tên Phòng");

        txttenkhTT.setEnabled(false);

        txttenphongTT.setEnabled(false);
        txttenphongTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenphongTTActionPerformed(evt);
            }
        });

        txtmahdTT.setEnabled(false);

        txttangTT.setEnabled(false);

        txttiendua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttienduaKeyReleased(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel73.setText("Tiền Thừa");

        txttienthua.setEnabled(false);

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel74.setText("Tổng Tiền");

        txttongtienTT.setEnabled(false);

        btnthanhtoan.setText("Thanh Toán");
        btnthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(74, 74, 74)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmahdTT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenphongTT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel34))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttangTT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenkhTT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel74))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttiendua, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txttongtienTT, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(147, 147, 147)
                                        .addComponent(btnthanhtoan))))
                            .addComponent(jLabel73))))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtmahdTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(txttenkhTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txttenphongTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txttangTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttiendua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(txttongtienTT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthanhtoan))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(txttienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        tblHoaDOn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Tên KH", "Ngày CheckIn", "Ngày Checkout", "Tên Phòng", "Tầng", "Tổng Tiền", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDOnMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHoaDOn);

        javax.swing.GroupLayout ThanhToanLayout = new javax.swing.GroupLayout(ThanhToan);
        ThanhToan.setLayout(ThanhToanLayout);
        ThanhToanLayout.setHorizontalGroup(
            ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThanhToanLayout.createSequentialGroup()
                .addGroup(ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThanhToanLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ThanhToanLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        ThanhToanLayout.setVerticalGroup(
            ThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThanhToanLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        MHCHinh.add(ThanhToan, "card5");

        DichVu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setText("QUẢN LÍ DỊCH VỤ");

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Mã DV:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setText("Tên DV:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Giá:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setText("Làm mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSuaDV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaDV.setText("Sửa DV");
        btnSuaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDVActionPerformed(evt);
            }
        });

        btnXoaDV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaDV.setText("Xóa DV");
        btnXoaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDVActionPerformed(evt);
            }
        });

        btnThemDV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemDV.setText("Lưu DV");
        btnThemDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem)
                            .addComponent(btnSuaDV))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoaDV)
                            .addComponent(btnThemDV)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)))
                            .addComponent(jLabel28)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addGap(34, 34, 34)
                .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoaDV))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaDV)
                    .addComponent(btnThemDV))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết thông tin dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã DV", "Tên dịch vụ", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDV);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DichVuLayout = new javax.swing.GroupLayout(DichVu);
        DichVu.setLayout(DichVuLayout);
        DichVuLayout.setHorizontalGroup(
            DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DichVuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407))
        );
        DichVuLayout.setVerticalGroup(
            DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        MHCHinh.add(DichVu, "card6");

        NhanVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel18.setText("QUẢN LÍ NHÂN VIÊN");

        jPanel20.setBackground(new java.awt.Color(204, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin  nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setText("Mã NV:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setText("Tên NV:");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setText("Ngày sinh:");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setText("Giới tính:");

        buttonGroup2.add(rdonunv);
        rdonunv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdonunv.setText("Nữ");
        rdonunv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdonunvActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdonvnam);
        rdonvnam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdonvnam.setSelected(true);
        rdonvnam.setText("Nam");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel97.setText("Số CCCD:");

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel98.setText("Số ĐT:");

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel99.setText("Địa chỉ:");

        btnclearnv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnclearnv.setText("Làm mới");
        btnclearnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearnvActionPerformed(evt);
            }
        });

        btnxoanv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoanv.setText("Xóa");
        btnxoanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoanvActionPerformed(evt);
            }
        });

        btnsuanv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsuanv.setText("Sửa");
        btnsuanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuanvActionPerformed(evt);
            }
        });

        btnluunv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnluunv.setText("Lưu");
        btnluunv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluunvActionPerformed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel100.setText("Email");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel101.setText("Pass");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98)
                            .addComponent(jLabel99)
                            .addComponent(btnxoanv, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnclearnv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtngaysinhnv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(rdonvnam, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdonunv, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addComponent(txtcccdnv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachinv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnluunv, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsuanv, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)))))
                .addGap(10, 10, 10))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(txtmanv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtngaysinhnv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(rdonunv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdonvnam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(txtcccdnv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(txtsdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiachinv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsuanv)
                    .addComponent(btnclearnv))
                .addGap(34, 34, 34)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnluunv)
                    .addComponent(btnxoanv))
                .addGap(41, 41, 41))
        );

        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã NV", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "SCCCD", "SĐT", "Địa chỉ", "Email", "PassWord"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblnhanvien);

        javax.swing.GroupLayout NhanVienLayout = new javax.swing.GroupLayout(NhanVien);
        NhanVien.setLayout(NhanVienLayout);
        NhanVienLayout.setHorizontalGroup(
            NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(358, 358, 358))
            .addGroup(NhanVienLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NhanVienLayout.setVerticalGroup(
            NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVienLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        MHCHinh.add(NhanVien, "card7");

        ThongKe.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel21.setText("Thống kê");

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel22.setText("Doanh thu ngày");

        jLabel23.setText("Ngày");

        jLabel24.setText("Số Hóa Đơn");

        jLabel25.setText("Doanh Thu Tổng");

        txtdoanhthungay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdoanhthungayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdoanhthungay, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txtDoanhThuTongNgay)
                            .addComponent(txtsohoadonngay))))
                .addGap(241, 241, 241))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdoanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsohoadonngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDoanhThuTongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel40.setText("Doanh thu Tháng");

        jLabel59.setText("Tháng");

        jLabel60.setText("Số Hóa Đơn Tháng");

        jLabel70.setText("Doanh Thu Tổng Tháng");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdoanhthuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel70)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDoanhThuTongThang, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtSoHoaDonThang)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap(147, Short.MAX_VALUE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdoanhthuThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtSoHoaDonThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDoanhThuTongThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(204, 255, 255));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel79.setText("Doanh thu năm");

        jLabel80.setText("Năm");

        jLabel81.setText("Số Hóa Đơn Năm");

        jLabel82.setText("Doanh Thu Tổng Năm");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdoanhthuNam)
                    .addComponent(txtSoHoaDonNam)
                    .addComponent(txtDoanhThuTongNam, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addGap(149, 149, 149))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdoanhthuNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(txtSoHoaDonNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDoanhThuTongNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ngày", "Số hóa đơn", "Doanh thu tổng"
            }
        ));
        jScrollPane6.setViewportView(tblThongKe);

        cbbNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNgayActionPerformed(evt);
            }
        });

        jLabel107.setText("Ngày");

        jLabel108.setText("Tháng");

        jLabel109.setText("Năm");

        btnThongKe1.setText("Thống Kê");
        btnThongKe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKe1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
        ThongKe.setLayout(ThongKeLayout);
        ThongKeLayout.setHorizontalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ThongKeLayout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addGap(18, 18, 18)
                        .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364)
                        .addComponent(jLabel108)
                        .addGap(18, 18, 18)
                        .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)
                        .addComponent(jLabel109)
                        .addGap(26, 26, 26)
                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
            .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ThongKeLayout.createSequentialGroup()
                    .addGap(495, 495, 495)
                    .addComponent(jLabel21)
                    .addContainerGap(559, Short.MAX_VALUE)))
        );
        ThongKeLayout.setVerticalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNgay)
                    .addComponent(jLabel107)
                    .addComponent(cbbThang)
                    .addComponent(jLabel108)
                    .addComponent(jLabel109)
                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThongKe1))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ThongKeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(608, Short.MAX_VALUE)))
        );

        MHCHinh.add(ThongKe, "card8");

        Menu.setBackground(new java.awt.Color(255, 255, 255));

        btnTrangCHu.setBackground(new java.awt.Color(204, 255, 255));
        btnTrangCHu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnTrangCHu.setText("Trang chủ");
        btnTrangCHu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangCHuActionPerformed(evt);
            }
        });

        btnPhong.setBackground(new java.awt.Color(204, 255, 255));
        btnPhong.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnPhong.setText("Phòng");
        btnPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhongActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(204, 255, 255));
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnThanhToanđaoien.setBackground(new java.awt.Color(204, 255, 255));
        btnThanhToanđaoien.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnThanhToanđaoien.setText("Thanh toán");
        btnThanhToanđaoien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanđaoienActionPerformed(evt);
            }
        });

        btnDIchVu.setBackground(new java.awt.Color(204, 255, 255));
        btnDIchVu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDIchVu.setText("Dịch vụ");
        btnDIchVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDIchVuActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(204, 255, 255));
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnThongKedaodien.setBackground(new java.awt.Color(204, 255, 255));
        btnThongKedaodien.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnThongKedaodien.setText("Thống kê");
        btnThongKedaodien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKedaodienActionPerformed(evt);
            }
        });

        Dangxuat.setBackground(new java.awt.Color(204, 255, 255));
        Dangxuat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Dangxuat.setText("Đăng xuất");
        Dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangxuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThongKedaodien, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDIchVu, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToanđaoien, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrangCHu, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnTrangCHu)
                .addGap(18, 18, 18)
                .addComponent(btnPhong)
                .addGap(18, 18, 18)
                .addComponent(btnKhachHang)
                .addGap(18, 18, 18)
                .addComponent(btnThanhToanđaoien)
                .addGap(18, 18, 18)
                .addComponent(btnDIchVu)
                .addGap(18, 18, 18)
                .addComponent(btnNhanVien)
                .addGap(18, 18, 18)
                .addComponent(btnThongKedaodien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(Dangxuat)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(LoGo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(875, 875, 875))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MHCHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LoGo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MHCHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        // TODO add your handling code here:
        int r = tblPhong.getSelectedRow();
        txtmaphong.setText(tblPhong.getValueAt(r, 1).toString());
        txttenPhong.setText(tblPhong.getValueAt(r, 2).toString());
        txtTang.setText(tblPhong.getValueAt(r, 3).toString());
        txtLoaiPhong.setText(tblPhong.getValueAt(r, 4).toString());

        txtgiatheogio.setText(tblPhong.getValueAt(r, 5).toString());
        txtgiatheongay.setText(tblPhong.getValueAt(r, 6).toString());
        txtsonguoitoida.setText(tblPhong.getValueAt(r, 7).toString());
    }//GEN-LAST:event_tblPhongMouseClicked

    private void btnTimKiemKhachHanngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhachHanngActionPerformed
        //        List<KhachHang> lisst = khachHangService.Getlist();
        //        String ma = txtTimKiemKhachHang.getText();
        //        int r = tblKhachHang.getSelectedRow();
        //        DefaultTableModel defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        //        defaultTableModel.setRowCount(0);
        //        for (KhachHang x : lisst) {
        //            if (tblKhachHang.getValueAt(r, 1).toString().equals(ma)) {
        //                defaultTableModel.addRow(new Object[]{
        //                    defaultTableModel.getRowCount() + 1, x.getHoVaTen(), x.getNgaySinh(), x.getGioiTinh(), x.getsCCCD(), x.getsDT(), x.getDiaChi()
        //                });
        //            } else {
        //            }
        //        }
    }//GEN-LAST:event_btnTimKiemKhachHanngActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int r = tblKhachHang.getSelectedRow();
        txtMaKH.setText(tblKhachHang.getValueAt(r, 1).toString());
        txttenkh.setText(tblKhachHang.getValueAt(r, 2).toString());
        txtngaysinhkh.setText(tblKhachHang.getValueAt(r, 3).toString());
        if (tblKhachHang.getValueAt(r, 4).toString().equalsIgnoreCase("Nam")) {
            rdoNamkh.setSelected(true);
        } else {
            rdNukh.setSelected(true);
        }
        txtcccd.setText(tblKhachHang.getValueAt(r, 5).toString());
        txtsdt.setText(tblKhachHang.getValueAt(r, 6).toString());
        txtdiachi.setText(tblKhachHang.getValueAt(r, 7).toString());
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        clearFormDV();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDVActionPerformed

        int selectedRow = tblDV.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dịch vụ cần sửa trên table");
            return;
        }
        String maDV = tblDV.getValueAt(selectedRow, 1).toString();
        DichVu dv = new DichVu();
        dv.setMaDichVu(txtMaDV.getText());
        dv.setLoaiDichVu(txtTenDV.getText());
        dv.setPhiDichVu(Float.parseFloat(txtGia.getText()));

        if (dichVuService.update(dv, maDV)) {
            JOptionPane.showMessageDialog(this, "Cap nhat thanh cong");
            loadTabledichvu();
        } else {
            JOptionPane.showMessageDialog(this, "Cap nhat that bai");
        }

    }//GEN-LAST:event_btnSuaDVActionPerformed

    private void btnXoaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDVActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDV.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dịch vụ cần xóa trên table");
            return;
        }
        String maDV = tblDV.getValueAt(selectedRow, 1).toString();
        if (dichVuService.delete(maDV)) {
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
            loadTabledichvu();
        } else {
            JOptionPane.showMessageDialog(this, "Xoa that bai");
        }

    }//GEN-LAST:event_btnXoaDVActionPerformed

    private void btnThemDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDVActionPerformed

        DichVu dv = getformDV();
        if (dichVuService.add(dv)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTabledichvu();
//            loadCBBDichVu(dichVuService.getAll());
            return;
        }
        JOptionPane.showMessageDialog(this, "Thêm thất bại");
        return;

    }//GEN-LAST:event_btnThemDVActionPerformed

    private void tblDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDVMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblDV.getSelectedRow();
        txtMaDV.setText(tblDV.getValueAt(selectedRow, 1).toString());
        txtTenDV.setText(tblDV.getValueAt(selectedRow, 2).toString());
        txtGia.setText(tblDV.getValueAt(selectedRow, 3).toString());
    }//GEN-LAST:event_tblDVMouseClicked

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked
        // TODO add your handling code here:
        int r = tblnhanvien.getSelectedRow();
        txtmanv.setText(tblnhanvien.getValueAt(r, 1).toString());
        txttennv.setText(tblnhanvien.getValueAt(r, 2).toString());
        txtngaysinhnv.setText(tblnhanvien.getValueAt(r, 3).toString());
        if (tblnhanvien.getValueAt(r, 4).toString().equalsIgnoreCase("Nam")) {
            rdonvnam.setSelected(true);
        } else {
            rdonunv.setSelected(true);
        }
        txtcccdnv.setText(tblnhanvien.getValueAt(r, 5).toString());
        txtsdtnv.setText(tblnhanvien.getValueAt(r, 6).toString());
        txtDiachinv.setText(tblnhanvien.getValueAt(r, 7).toString());
        txtemail.setText(tblnhanvien.getValueAt(r, 8).toString());
        txtpass.setText(tblnhanvien.getValueAt(r, 9).toString());
    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void btnTrangCHuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangCHuActionPerformed
        this.Trangchu.setVisible(true);
        this.Phong.setVisible(false);
        this.KhachHang.setVisible(false);
        this.ThanhToan.setVisible(false);
        this.DichVu.setVisible(false);
        this.NhanVien.setVisible(false);
        this.ThongKe.setVisible(false);
    }//GEN-LAST:event_btnTrangCHuActionPerformed

    private void btnPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhongActionPerformed
        this.Trangchu.setVisible(false);
        this.Phong.setVisible(true);
        this.KhachHang.setVisible(false);
        this.ThanhToan.setVisible(false);
        this.DichVu.setVisible(false);
        this.NhanVien.setVisible(false);
        this.ThongKe.setVisible(false);
    }//GEN-LAST:event_btnPhongActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        this.Trangchu.setVisible(false);
        this.Phong.setVisible(false);
        this.KhachHang.setVisible(true);
        this.ThanhToan.setVisible(false);
        this.DichVu.setVisible(false);
        this.NhanVien.setVisible(false);
        this.ThongKe.setVisible(false);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnThanhToanđaoienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanđaoienActionPerformed
        this.Trangchu.setVisible(false);
        this.Phong.setVisible(false);
        this.KhachHang.setVisible(false);
        this.ThanhToan.setVisible(true);
        this.DichVu.setVisible(false);
        this.NhanVien.setVisible(false);
        this.ThongKe.setVisible(false);
    }//GEN-LAST:event_btnThanhToanđaoienActionPerformed

    private void btnDIchVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDIchVuActionPerformed
        this.Trangchu.setVisible(false);
        this.Phong.setVisible(false);
        this.KhachHang.setVisible(false);
        this.ThanhToan.setVisible(false);
        this.DichVu.setVisible(true);
        this.NhanVien.setVisible(false);
        this.ThongKe.setVisible(false);
    }//GEN-LAST:event_btnDIchVuActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        this.Trangchu.setVisible(false);
        this.Phong.setVisible(false);
        this.KhachHang.setVisible(false);
        this.ThanhToan.setVisible(false);
        this.DichVu.setVisible(false);
        this.NhanVien.setVisible(true);
        this.ThongKe.setVisible(false);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnThongKedaodienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKedaodienActionPerformed
        this.Trangchu.setVisible(false);
        this.Phong.setVisible(false);
        this.KhachHang.setVisible(false);
        this.ThanhToan.setVisible(false);
        this.DichVu.setVisible(false);
        this.NhanVien.setVisible(false);
        this.ThongKe.setVisible(true);
    }//GEN-LAST:event_btnThongKedaodienActionPerformed

    private void txtdoanhthungayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdoanhthungayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdoanhthungayActionPerformed

    private void btnclearKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearKhActionPerformed
        this.clearFormKhachHang();
    }//GEN-LAST:event_btnclearKhActionPerformed
    public void clearFormKhachHang() {
        txttenkh.setText("");
        txtMaKH.setText("");
        txtsdt.setText("");
        txtdiachi.setText("");
        txtcccd.setText("");
        txtngaysinhkh.setText("");
    }
    private void btnSuakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuakhActionPerformed
        int r = tblKhachHang.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 khach hang can sua tren table");
            return;
        }
        KhachHang kh = new KhachHang();

        String makh = txtMaKH.getText();
        String ngaysinh = txtngaysinhkh.getText();
        String id = ks.findid(makh);
        String tenkh = txttenkh.getText();

        String cccd = txtcccd.getText();
        if (rdoNamkh.isSelected()) {
            kh.setGioiTinh("Nam");
        }
        if (rdNukh.isSelected()) {
            kh.setGioiTinh("Nu");
        }
        String sdt = txtsdt.getText();
        String diachi = txtdiachi.getText();

        if (makh.isEmpty() || tenkh.isEmpty() || cccd.isEmpty() || sdt.isEmpty() || diachi.isEmpty() || ngaysinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return;
        }
        if (makh.matches("[a-zA-Z0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Sai dinh dang MANV");
            txtmanv.requestFocus();
            return;
        }

        if (tenkh.matches("^[a-zA-Z\\s]+$") == false) {
            JOptionPane.showMessageDialog(this, "Sai dinh dang ho ten");
            txttennv.requestFocus();
            return;
        }

        try {
            java.sql.Date ngaySinh = java.sql.Date.valueOf(txtngaysinhkh.getText().trim());
            kh.setNgaySinh(ngaySinh);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày sinh");
            return;
        }
        if (sdt.matches("0[0-9]{9}") == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng sđt");
            return;
        }
        kh.setDiaChi(diachi);
        kh.setHoVaTen(tenkh);
        kh.setMa(makh);

        kh.setsCCCD(cccd);
        kh.setsDT(sdt);

        if (ks.Sua(id, kh)) {
            JOptionPane.showMessageDialog(this, "Sửa thông tin khách hàng thành công");
            loadKhachHang(ks.Getlist());
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thông tin khách hàng thất bại");
        }
    }//GEN-LAST:event_btnSuakhActionPerformed

    private void btnluukhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluukhActionPerformed
        KhachHang kh = new KhachHang();

        String makh = txtMaKH.getText();
        String tenkh = txttenkh.getText();
        String ngaysinh = txtngaysinhkh.getText();
        String cccd = txtcccd.getText();
        if (rdoNamkh.isSelected()) {
            kh.setGioiTinh("Nam");
        } else {
            kh.setGioiTinh("Nu");
        }
        String sdt = txtsdt.getText();
        String diachi = txtdiachi.getText();

        if (makh.isEmpty() || tenkh.isEmpty() || cccd.isEmpty() || sdt.isEmpty() || diachi.isEmpty() || ngaysinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return;
        }

        if (makh.matches("[a-zA-Z0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Sai dinh dang MANV");
            txtmanv.requestFocus();
            return;
        }
        List<KhachHang> l = ks.getListKHByMa(makh);
        for (KhachHang x : l) {
            if (x.getMa().equals(makh)) {
                JOptionPane.showMessageDialog(this, "Da ton tai MAKH");
                return;
            } else {
                break;
            }
        }
        List<KhachHang> l1 = ks.getListNVBycccd(makh);
        for (KhachHang x : l1) {
            if (x.getsCCCD().equals(cccd)) {
                JOptionPane.showMessageDialog(this, "Da ton tai So CCCD");
                return;
            } else {
                break;
            }
        }
        List<KhachHang> l2 = ks.getListNVBySDT(sdt);
        for (KhachHang x : l2) {
            if (x.getsDT().equals(sdt)) {
                JOptionPane.showMessageDialog(this, "Da ton tai SDT");
                return;
            } else {
                break;
            }
        }

        if (tenkh.matches("^[a-zA-Z\\s]+$") == false) {
            JOptionPane.showMessageDialog(this, "Sai dinh dang ho ten");
            txttennv.requestFocus();
            return;
        }

        try {
            java.sql.Date ngaySinh = java.sql.Date.valueOf(txtngaysinhkh.getText().trim());
            kh.setNgaySinh(ngaySinh);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày sinh");
            return;
        }
        if (sdt.matches("0[0-9]{9}") == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng sđt");
            return;
        }

        kh.setDiaChi(diachi);
        kh.setHoVaTen(tenkh);
        kh.setMa(makh);
        kh.setsCCCD(cccd);
        kh.setsDT(sdt);

        if (ks.Them(kh)) {
            JOptionPane.showMessageDialog(this, "Thêm mới khách hàng thành công");
            loadKhachHang(ks.Getlist());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm mới khách hàng thất bại");
        }


    }//GEN-LAST:event_btnluukhActionPerformed

    private void btnluuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuPhongActionPerformed
        // TODO add your handling code here:
        Phong ctp = new Phong();

        String maPhong = txtmaphong.getText();
        String tang = txtTang.getText();
        String giatheogio = txtgiatheogio.getText();
        String giatheongay = txtgiatheongay.getText();
        String songuoitoida = txtsonguoitoida.getText();
        String loaiPhong = txtLoaiPhong.getText();
        String tenPhong = txttenPhong.getText();

        ctp.setTenPhong(tenPhong);
        ctp.setMaPhong(maPhong);
        ctp.setTang(Integer.parseInt(tang));
        ctp.setGiaTheoGio(Float.parseFloat(giatheogio));
        ctp.setGiaTheoNgay(Float.parseFloat(giatheongay));
        ctp.setSoNguoiToiDa(Integer.parseInt(songuoitoida));
        ctp.setLoaiPhong(loaiPhong);
        ctp.setTrangThai(false);

        if (phongService.Them(ctp)) {
            JOptionPane.showMessageDialog(this, "Thêm mới phòng thành công");
            loadPhong(phongService.getAll());
            Trangchu.removeAll();
            loadHomePage();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm mới phòng thất bại");
        }

    }//GEN-LAST:event_btnluuPhongActionPerformed

    private void btnsuaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaPhongActionPerformed
        // TODO add your handling code here:

        Phong ctp = new Phong();

        String maPhong = txtmaphong.getText();
        String id = phongService.find(maPhong);
        String tang = txtTang.getText();
        String giatheogio = txtgiatheogio.getText();
        String giatheongay = txtgiatheongay.getText();
        String songuoitoida = txtsonguoitoida.getText();
        String loaiPhong = txtLoaiPhong.getText();
        String tenPhong = txttenPhong.getText();

        ctp.setTenPhong(tenPhong);
        ctp.setMaPhong(maPhong);
        ctp.setTang(Integer.parseInt(tang));
        ctp.setGiaTheoGio(Float.parseFloat(giatheogio));
        ctp.setGiaTheoNgay(Float.parseFloat(giatheongay));
        ctp.setSoNguoiToiDa(Integer.parseInt(songuoitoida));
        ctp.setLoaiPhong(loaiPhong);
        ctp.setTrangThai(false);

        if (phongService.Sua(id, ctp)) {
            JOptionPane.showMessageDialog(this, "Sửa phòng thành công");
            loadPhong(phongService.getAll());
            Trangchu.removeAll();
            loadHomePage();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa phòng thất bại");
        }
    }//GEN-LAST:event_btnsuaPhongActionPerformed

    private void btnxoaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaPhongActionPerformed
        // TODO add your handling code here:
        int cf = JOptionPane.showConfirmDialog(this, "Ban muon xoa phong nay khong ?");
        if (cf == JOptionPane.YES_OPTION) {
            int selectedRow = tblPhong.getSelectedRow();
            String ma = tblPhong.getValueAt(selectedRow, 1).toString();
//        String id =phongService.find(ma);
            if (phongService.Xoa(ma)) {
                JOptionPane.showMessageDialog(this, "Xoa thanh cong");
                loadPhong(phongService.getAll());
                Trangchu.removeAll();
                loadHomePage();
            } else {
                JOptionPane.showMessageDialog(this, "Xoa that bai");
            }
        } else {
        }

    }//GEN-LAST:event_btnxoaPhongActionPerformed

    private void txttienduaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttienduaKeyReleased
        List<ThongTinHoaDon> list = hoaDonViewService.getListHDVByMa(txtmahdTT.getText().trim());
        for (ThongTinHoaDon hd : list) {
            try {
                float tienKhach = Float.parseFloat(txttiendua.getText());
                float tienThua = tienKhach - (hd.getTongTien());
                txttienthua.setText(numberFM.format(tienThua));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txttienduaKeyReleased

    private void btnthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthanhtoanActionPerformed
        int r = tblHoaDOn.getSelectedRow();
        String hoadon = txtmahdTT.getText().trim();
        String kh = txttenkhTT.getText().trim();
        String tang = txttangTT.getText().trim();
        String tp = txttenphongTT.getText().trim();
        String td = txttiendua.getText().trim();
        if (hoadon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hóa đơn cần thanh toán");
            return;
        }
        if (kh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hóa đơn cần thanh toán");
            return;
        }
        if (tang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hóa đơn cần thanh toán");
            return;
        }
        if (tp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hóa đơn cần thanh toán");
            return;
        }
        if (td.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền khách hàng đưa");
            return;
        }

        try {
            Float.parseFloat(td);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng tiền đưa");
            return;
        }

        List<ThongTinHoaDon> listhdv = hoaDonViewService.getAll();
        List<HoaDon> list = hoadonservice.getAll();
        for (ThongTinHoaDon hdv : listhdv) {
            if (hdv.getMa().equals(txtmahdTT.getText().trim())) {
                for (HoaDon hd : list) {
                    if (hd.getTinhTrang().equalsIgnoreCase("Da thanh toan")) {
                        JOptionPane.showMessageDialog(this, "Hóa đơn này đã thanh toán");
                        return;
                    } else {
                        if (hd.getMa().equals(txtmahdTT.getText().trim())) {
                            if (Float.parseFloat(td) < hd.getTongTien()) {
                                JOptionPane.showMessageDialog(this, "Số tiền đưa không đủ");
                                return;
                            }
                            hoadonservice.updateTT(hd.getMa(), hd);
                            getPhong(txtTenPhongTT.getText().trim());
                            Trangchu.removeAll();
                            loadHomePage();
                            tblPhong.removeAll();
                            loadPhong(phongService.getAll());
                            String maHDVUPdate = txtmahdTT.getText().trim();
                            hoadonservice.delete(hd.getId());
                            List<Phong> li = phongService.getListPhongByTen(txtTenPhongTT.getText());
                            for (Phong x : li) {
                                ti.delete(x.getId());
                                dichVuDungService.delete(x.getId());
                            }
                        }
                        hoaDonViewService.updateTT(hdv.getMa(), hdv);
                        JOptionPane.showMessageDialog(this, "Thanh toan thanh cong");
                        loadHoaDonView(hoaDonViewService.getAll());
                        
                    }

                }
            }
        }
//        JOptionPane.showMessageDialog(this, "Thanh toan that bai");
    }//GEN-LAST:event_btnthanhtoanActionPerformed

    private void tblHoaDOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDOnMouseClicked
        // TODO add your handling code here:

        int row = tblHoaDOn.getSelectedRow();

        txtmahdTT.setText(tblHoaDOn.getValueAt(row, 1).toString());
        txttenkhTT.setText(tblHoaDOn.getValueAt(row, 2).toString());
        txttenphongTT.setText(tblHoaDOn.getValueAt(row, 5).toString());
        txttangTT.setText(tblHoaDOn.getValueAt(row, 6).toString());
        txttongtienTT.setText(tblHoaDOn.getValueAt(row, 7).toString());

    }//GEN-LAST:event_tblHoaDOnMouseClicked

    private void cbbNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNgayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNgayActionPerformed

    private void btnThongKe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKe1ActionPerformed
        String date = cbbNgay.getSelectedItem().toString();
        String month = cbbThang.getSelectedItem().toString();
        String year = cbbNam.getSelectedItem().toString();
        if (!date.equals("") && !month.equals("")) {
            String dateTime = year + "-" + month + "-" + date;
            List<ThongKeView> list = thongKeService.queryByDay(dateTime);
            float tongTien = 0.0f;
            int soHD = 0;
            for (ThongKeView tk : list) {
                tongTien += tk.getTongTien();
                soHD = tk.getSoHoaDon();
            }
            txtdoanhthungay.setText(date + " - " + month + " - " + year);
            txtdoanhthuThang.setText("");
            txtdoanhthuNam.setText("");

            txtsohoadonngay.setText("" + soHD);
            txtSoHoaDonThang.setText("");
            txtSoHoaDonNam.setText("");

            txtDoanhThuTongNgay.setText("" + numberFM.format(tongTien));
            txtDoanhThuTongThang.setText("");
            txtDoanhThuTongNam.setText("");
            showThongKe(list);
        } else {
            if (date.equals("") && !month.equals("")) {
                List<ThongKeView> list = thongKeService.queryByMonth(month, year);
                float tongTien = 0.0f;
                int soHD = 0;
                for (ThongKeView tk : list) {
                    tongTien += tk.getTongTien();
                    soHD = tk.getSoHoaDon();
                }
                txtdoanhthungay.setText("");
                txtdoanhthuThang.setText(month + " - " + year);
                txtdoanhthuNam.setText("");

                txtsohoadonngay.setText("");
                txtSoHoaDonThang.setText("" + soHD);
                txtSoHoaDonNam.setText("");

                txtDoanhThuTongNgay.setText("");
                txtDoanhThuTongThang.setText("" + numberFM.format(tongTien));
                txtDoanhThuTongNam.setText("");

                showThongKe(list);
            }
            if (month.equals("")) {
                List<ThongKeView> list = thongKeService.queryByYear(year);
                float tongTien = 0.0f;
                int soHD = 0;
                for (ThongKeView tk : list) {
                    tongTien += tk.getTongTien();
                    soHD = tk.getSoHoaDon();
                }
                txtdoanhthungay.setText("");
                txtdoanhthuThang.setText("");
                txtdoanhthuNam.setText(year);

                txtsohoadonngay.setText("");
                txtSoHoaDonThang.setText("");
                txtSoHoaDonNam.setText("" + soHD);

                txtDoanhThuTongNgay.setText("");
                txtDoanhThuTongThang.setText("");
                txtDoanhThuTongNam.setText("" + numberFM.format(tongTien));

                showThongKe(list);
            }
        }
    }//GEN-LAST:event_btnThongKe1ActionPerformed

    private void rdonunvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdonunvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdonunvActionPerformed

    private void btnluunvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluunvActionPerformed
        // TODO add your handling code here:
        NguoiDung nv = new NguoiDung();

        String manv = txtmanv.getText();
        String tennv = txttennv.getText();
        String ngaysinh = txtngaysinhnv.getText();
        String cccdnv = txtcccdnv.getText();
        if (rdonvnam.isSelected()) {
            nv.setGioiTinh("Nam");
        } else {
            nv.setGioiTinh("Nu");
        }
        String sdtnv = txtsdtnv.getText();
        String diachinv = txtDiachinv.getText();
        String email = txtemail.getText();
        String pass = txtpass.getText();

        if (manv.isEmpty() || tennv.isEmpty() || sdtnv.isEmpty() || diachinv.isEmpty() || email.isEmpty() || pass.isEmpty() || cccdnv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống dữ liệu");
            return;
        }

        if (manv.matches("[a-zA-Z0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Sai dinh dang MANV");
            txtmanv.requestFocus();
            return;
        }
        List<NguoiDung> l = nhanVienService.getListNVByMa(manv);
        for (NguoiDung x : l) {
            if (x.getMa().equals(manv)) {
                JOptionPane.showMessageDialog(this, "Da ton tai MANV");
                return;
            } else {
                break;
            }
        }

        List<NguoiDung> l2 = nhanVienService.getListNVBycccd(cccdnv);
        for (NguoiDung x : l2) {
            if (x.getcCCD().equals(cccdnv)) {
                JOptionPane.showMessageDialog(this, "Da ton tai CCCD");
                return;
            } else {
                break;
            }
        }
        List<NguoiDung> l1 = nhanVienService.getListNVBySDT(sdtnv);
        for (NguoiDung x : l1) {
            if (x.getSdt().equals(sdtnv)) {
                JOptionPane.showMessageDialog(this, "Da ton tai SĐT");
                return;
            } else {
                break;
            }
        }
        List<NguoiDung> l3 = nhanVienService.getListNVByEmail(email);
        for (NguoiDung x : l3) {
            if (x.getEmail().equals(email)) {
                JOptionPane.showMessageDialog(this, "Da ton tai Email");
                return;
            } else {
                break;
            }
        }

        if (tennv.matches("^[a-zA-Z\\s]+$") == false) {
            JOptionPane.showMessageDialog(this, "Sai dinh dang ho ten");
            txttennv.requestFocus();
            return;
        }

        if (sdtnv.matches("0[0-9]{9}") == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng sđt");
            return;
        }

        if (email.matches("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$") == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            return;
        }

        try {
            java.sql.Date ngaySinh = java.sql.Date.valueOf(txtngaysinhnv.getText().trim());
            nv.setNgaySinh(ngaySinh);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày sinh");
            return;
        }

        nv.setDiaChi(diachinv);
        nv.setHoVaTen(tennv);
        nv.setMa(manv);
        nv.setcCCD(cccdnv);
        nv.setSdt(sdtnv);
        nv.setEmail(email);
        nv.setPassWord(pass);

        if (nhanVienService.Them(nv)) {
            JOptionPane.showMessageDialog(this, "Thêm mới nhân viên thành công");
            loadNhanVien(nhanVienService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm mới nhân viên thất bại");
        }
    }//GEN-LAST:event_btnluunvActionPerformed

    private void btnsuanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanvActionPerformed
        // TODO add your handling code here:
        int r = tblnhanvien.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 Nhân viên can sua tren table");
            return;
        }

        NguoiDung nv = new NguoiDung();

        String manv = txtmanv.getText();
        String tennv = txttennv.getText();
        String ngaysinh = txtngaysinhnv.getText();
        String cccdnv = txtcccdnv.getText();
        if (rdonvnam.isSelected()) {
            nv.setGioiTinh("Nam");
        } else {
            nv.setGioiTinh("Nu");
        }
        String sdtnv = txtsdtnv.getText();
        String diachinv = txtDiachinv.getText();
        String email = txtemail.getText();
        String pass = txtpass.getText();

        String id = nhanVienService.find(manv);
        nv.setDiaChi(diachinv);
        nv.setHoVaTen(tennv);
        nv.setMa(manv);
        nv.setNgaySinh(java.sql.Date.valueOf(ngaysinh));
        nv.setcCCD(cccdnv);
        nv.setSdt(sdtnv);
        nv.setEmail(email);
        nv.setPassWord(pass);

        if (nhanVienService.Sua(id, nv)) {
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
            loadNhanVien(nhanVienService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại");
        }
    }//GEN-LAST:event_btnsuanvActionPerformed

    private void btnclearnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearnvActionPerformed

    private void btnxoanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoanvActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblnhanvien.getSelectedRow();
        String manv = tblnhanvien.getValueAt(selectedRow, 1).toString();
//        String id = khachHangService.find(manv);
        if (nhanVienService.Xoa(manv)) {
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
            loadNhanVien(nhanVienService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Xoa that bai");
        }
    }//GEN-LAST:event_btnxoanvActionPerformed

    private void DangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangxuatActionPerformed
        int row = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if(row == JOptionPane.NO_OPTION){
            return;
        }
        this.dispose();
        DangNhapView dnv = new DangNhapView();
        dnv.setVisible(true);
        dnv.setLocationRelativeTo(null);
    }//GEN-LAST:event_DangxuatActionPerformed

    private void txtSoNguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiActionPerformed

    private void btnTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKHActionPerformed

        List<KhachHang> listkh = ks.getListKHByMa(txtSearchKH.getText().trim());

        DefaultTableModel defaultTableModel = (DefaultTableModel) tbKH.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;
        if (txtSearchKH.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(DatTra, "Khong de trong!");
            return;
        }
        if (listkh.size() == 0) {
            JOptionPane.showMessageDialog(DatTra, "Khong ton tai khach hang nay!");
            return;
        }
        for (KhachHang kh : listkh) {

            Object[] row = new Object[8];
            row[0] = i++;
            row[1] = kh.getMa();
            row[2] = kh.getHoVaTen();
            row[3] = kh.getNgaySinh();
            row[4] = kh.getGioiTinh();
            row[5] = kh.getsCCCD();
            row[6] = kh.getsDT();
            row[7] = kh.getDiaChi();
            defaultTableModel.addRow(row);
        }
    }//GEN-LAST:event_btnTimKiemKHActionPerformed

    private void pnKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnKHMouseClicked

        //        KhachHang khachHang = new KhachHang();
        //
        //        String makh = txtMaKH.getText();
        //        String HoTen = txtTenKH.getText();
        //        java.sql.Date ngaySinh = java.sql.Date.valueOf(txtNgaySinh.getText().trim());
        //        if (rdNam.isSelected()) {
        //            khachHang.setGioiTinh("Nam");
        //        } else {
        //            khachHang.setGioiTinh("Nu");
        //        }
        //        String diaChi = txtDiaChi.getText();
        //        String CCCD = txtCCCD.getText();
        //        String sdt = txtsdt.getText();
        //        if (makh.length() == 0 || HoTen.length() == 0 || txtNgaySinh.getText().trim().equals("") || diaChi.length() == 0 || CCCD.length() == 0 || sdt.length() == 0 || !rdNam.isSelected() || !rdNu.isSelected()) {
        //            return;
        //        }
        //        khachHang.setMa(makh);
        //        khachHang.setDiaChi(diaChi);
        //
        //        khachHang.setHoVaTen(HoTen);
        //        khachHang.setNgaySinh(ngaySinh);
        //        khachHang.setsCCCD(CCCD);
        //        khachHang.setsDT(sdt);
        //        if (khachHangService.Them(khachHang)) {
        //
        //            //            JOptionPane.showMessageDialog(this, "Thêm thành công");
        //            loadKhachHang(khachHangService.Getlist());
        //            lblID.setText(khachHangService.find(makh));
        //        } else {
        //            //            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        //        }
    }//GEN-LAST:event_pnKHMouseClicked

    private void btnXoaDV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDV1ActionPerformed
        int r = tbHodDonCTDVD.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(DatTra, "Vui long check in truoc khi them dich vu");
            return;
        }
//        List<Phong> 
    }//GEN-LAST:event_btnXoaDV1ActionPerformed

    private void cbbDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbDVMouseClicked

    }//GEN-LAST:event_cbbDVMouseClicked

    private void btnThemDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDVDActionPerformed

        String sl = JOptionPane.showInputDialog(DatTra, "Nhập số lượng :");
        DichVuDung dvd = new DichVuDung();
        dvd.setNgayThue(txtTGThemDVD.getDate());
        DichVu d = (DichVu) cbbDV.getSelectedItem();
        dvd.setDichVu(d);
        dvd.setSoLuongSuDung(Integer.parseInt(sl));
        Phong p = (Phong) cbbTenPhong.getSelectedItem();
        dvd.setPhong(p);
        if (dichVuDungService.add(dvd)) {
            loadTableDVD(dichVuDungService.getAll());
        } else {
            return;
        }
    }//GEN-LAST:event_btnThemDVDActionPerformed

    private void tbTTThuePhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTTThuePhongMouseClicked
        int r = tbTTThuePhong.getSelectedRow();

//        txtTGThue.setDate(Date.valueOf(tbTTThuePhong.getValueAt(r, 4).toString()));
//        txtTGTra.setDate(Date.valueOf(tbTTThuePhong.getValueAt(r, 5).toString()));
        cbbHinhThucThue.setSelectedItem(tbTTThuePhong.getValueAt(r, 3).toString());
        txtSoNguoi.setText(tbTTThuePhong.getValueAt(r, 6).toString());
    }//GEN-LAST:event_tbTTThuePhongMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        ThongTinThuePhong tt = new ThongTinThuePhong();
        DefaultTableModel dm = (DefaultTableModel) tbTTThuePhong.getModel();

        if (txtSoNguoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(DatTra, "Vui lòng điền số người thuê phòng ");
            return;
        }
        if (Integer.parseInt(txtSoNguoi.getText()) <= 0) {
            JOptionPane.showMessageDialog(DatTra, "Số người phải > 0");
            return;
        }
//        List<Phong> list = phongService.getListPhongByTen(cbbTenPhong.getSelectedItem().toString());
//        for (Phong x : list) {
//            if (Integer.parseInt(txtSoNguoi.getText()) > x.getSoNguoiToiDa()) {
//                JOptionPane.showMessageDialog(DatTra, "Số người của phòng chỉ được <= " + x.getSoNguoiToiDa());
//                return;
//            }
//        }
//        if (dm.getRowCount() != 0) {
//            JOptionPane.showMessageDialog(DatTra, "Phong da cho thue, vui long chon phong trong!");
//            DatTra.dispose();
//            return;
//        }
        KhachHang kh = new KhachHang();

        String id = ks.findid(txtSearchKH.getText());

        kh.setId(id);
        tt.setKhachHang(kh);
        tt.setThoiGianThue(txtTGThue.getDate());
        tt.setThoiGianTra(txtTGTra.getDate());
        tt.setHinhThucThue((String) cbbHinhThucThue.getSelectedItem());
        tt.setSoNguoi(Integer.parseInt(txtSoNguoi.getText()));
        Phong p = (Phong) cbbTenPhong.getSelectedItem();

        tt.setPhong(p);

        if (ti.add(tt)) {
            JOptionPane.showMessageDialog(DatTra, "Check in thanh cong");
            phongService.UpdateTinhTrang(p, p.getMaPhong());
            Trangchu.removeAll();

            loadHomePage();
            clearDatTra();
            loadtttp();
            loadPhong(phongService.getAll());
            CBBtenPhong(phongService.getAll());
        } else {
            JOptionPane.showMessageDialog(DatTra, "Check in that bai");
        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnCheckIn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckIn1ActionPerformed
        DatTra.dispose();

    }//GEN-LAST:event_btnCheckIn1ActionPerformed

    private void btnTraPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraPhongActionPerformed
        int ques = JOptionPane.showConfirmDialog(DatTra, "Bạn có muốn trả phòng không?", "", JOptionPane.YES_NO_OPTION);
        if (ques == JOptionPane.YES_OPTION) {
            txtTgThue.setText("");
            txtTongphiDV.setText("");
            txtTongTienPhong.setText("");
            txtTienPhong.setText("");
            txtTienThanhToan.setText("");
            txtGhiChu.setText("");
            ThanhToanJframe.setVisible(true);
            ThanhToanJframe.setLocationRelativeTo(null);
            LoadTTThanhtoan();
            loadDVDTT(dichVuDungService.getAll());
            DatTra.dispose();
        } else {
        }
    }//GEN-LAST:event_btnTraPhongActionPerformed

    private void tbTTThuePhongTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTTThuePhongTTMouseClicked
        // TODO add your handling code here:
        int index = tbTTThuePhongTT.getSelectedRow();
        txtTienPhong.setText(tbTTThuePhongTT.getValueAt(index, 3).toString());
        txtTgThue.setText(tbTTThuePhongTT.getValueAt(index, 4).toString());
        txtTongTienPhong.setText(numberFM.format(Float.parseFloat(txtTgThue.getText()) * Float.parseFloat(txtTienPhong.getText())));
        txtTongphiDV.setText(numberFM.format(getThanhTien(txtTenPhongTT.getText().trim())));
        txtTienThanhToan.setText(numberFM.format(Float.parseFloat(txtTgThue.getText()) * Float.parseFloat(txtTienPhong.getText()) + getThanhTien(txtTenPhongTT.getText().trim())));
    }//GEN-LAST:event_tbTTThuePhongTTMouseClicked

    private void btnInhoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhoaDonActionPerformed
        HoaDon hd = getHoadon();
        int index = tbTTThuePhongTT.getSelectedRow();
        ThongTinHoaDon hdview = new ThongTinHoaDon();
        List<ThongTinThuePhong> list = ti.getAll();
        for (ThongTinThuePhong tttp : list) {
            if (tttp.getPhong().getTenPhong().equals(cbbTenPhong.getSelectedItem().toString())) {

                hd.setNgayTao(tttp.getThoiGianThue());
                hd.setNgayTraPhong(tttp.getThoiGianTra());
                hd.setTongTien(Float.parseFloat(tbTTThuePhongTT.getValueAt(index, 3).toString()) * Float.parseFloat(tbTTThuePhongTT.getValueAt(index, 4).toString()) + getThanhTien(cbbTenPhong.getSelectedItem().toString()));
                hd.setKhachHang(tttp.getKhachHang());
                hd.setTinhTrang("Chua thanh toan");
                hd.setThongTinThuePhong(tttp);

                hdview.setMa(hd.getMa());
                hdview.setNgayTao(tttp.getThoiGianThue());
                hdview.setNgayTraPhong(tttp.getThoiGianTra());
                hdview.setTang(tttp.getPhong().getTang());
                hdview.setTenPhong(tttp.getPhong().getTenPhong());
                hdview.setTenKhachHang(tttp.getKhachHang().getHoVaTen());
                hdview.setTongTien(Float.parseFloat(tbTTThuePhongTT.getValueAt(index, 3).toString()) * Float.parseFloat(tbTTThuePhongTT.getValueAt(index, 4).toString()) + getThanhTien(cbbTenPhong.getSelectedItem().toString()));
                hdview.setTinhTrang("Chua thanh toan");
            }
        }
        hoaDonViewService.add(hdview);
        if (hoadonservice.add(hd)) {
            loadHoaDonView(hoaDonViewService.getAll());
            String printText = "Ten khach hang: " + txtTenKHTT.getText().toString() + "\t\t"
                    + "So CCCD: " + txtSoCCCDTT.getText().toString() + "\n"
                    + "So dien thoai: " + txtSDTTT.getText().toString() + "\t\t"
                    + "Gioi tinh: " + cbbGioiTinhTT.getSelectedItem().toString() + "\n"
                    + "Ngay checkin: " + txtNgayCheckinTT.getText().toString() + "\n"
                    + "Ngay checkout: " + txtNgayCheckOutTT.getText().toString() + "\n"
                    + "Hinh thuc: " + cbbHinhThucThueTT.getSelectedItem().toString() + "\n"
                    + "So phong: " + txtTenPhongTT.getText().toString() + "\t\t"
                    + "Tang: " + txtTangTT.getText().toString() + "\n"
                    + "So tien can thanh toan: " + txtTienThanhToan.getText().toString() + "VND";

            JTextPane thongTinHoaDon = new JTextPane();
            thongTinHoaDon.setText(printText);
            try {
                thongTinHoaDon.print();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(ThanhToan, "In hoa don that bai");
            }
            ThanhToanJframe.dispose();

        } else {
            JOptionPane.showMessageDialog(ThanhToan, "In hoa don that bai");
        }

    }//GEN-LAST:event_btnInhoaDonActionPerformed

    private void btnHuyInHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyInHdActionPerformed

    }//GEN-LAST:event_btnHuyInHdActionPerformed

    private void txttenphongTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenphongTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenphongTTActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLKS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKS.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dangxuat;
    private javax.swing.JFrame DatTra;
    private javax.swing.JPanel DatTraPhong;
    private javax.swing.JPanel DichVu;
    private javax.swing.JPanel KhachHang;
    private javax.swing.JLabel LoGo;
    private javax.swing.JPanel MHCHinh;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel NhanVien;
    private javax.swing.JPanel Phong;
    private javax.swing.JPanel ThanhToan;
    private javax.swing.JFrame ThanhToanJframe;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JPanel Trangchu;
    private javax.swing.JButton btnCheckIn1;
    private javax.swing.JButton btnDIchVu;
    private javax.swing.JButton btnHuyInHd;
    private javax.swing.JButton btnInhoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnPhong;
    private javax.swing.JButton btnSuaDV;
    private javax.swing.JButton btnSuakh;
    private javax.swing.JButton btnThanhToanđaoien;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDV;
    private javax.swing.JButton btnThemDVD;
    private javax.swing.JButton btnThongKe1;
    private javax.swing.JButton btnThongKedaodien;
    private javax.swing.JButton btnTimKiemKH;
    private javax.swing.JButton btnTimKiemKhachHanng;
    private javax.swing.JButton btnTraPhong;
    private javax.swing.JButton btnTrangCHu;
    private javax.swing.JButton btnXoaDV;
    private javax.swing.JButton btnXoaDV1;
    private javax.swing.JButton btnclearKh;
    private javax.swing.JButton btnclearPhong;
    private javax.swing.JButton btnclearnv;
    private javax.swing.JButton btnluuPhong;
    private javax.swing.JButton btnluukh;
    private javax.swing.JButton btnluunv;
    private javax.swing.JButton btnsuaPhong;
    private javax.swing.JButton btnsuanv;
    private javax.swing.JButton btnthanhtoan;
    private javax.swing.JButton btnxoaPhong;
    private javax.swing.JButton btnxoanv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbDV;
    private javax.swing.JComboBox<String> cbbGioiTinhTT;
    private javax.swing.JComboBox<String> cbbHinhThucThue;
    private javax.swing.JComboBox<String> cbbHinhThucThueTT;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbTenPhong;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTenP;
    private javax.swing.JPanel pnKH;
    private javax.swing.JRadioButton rdNukh;
    private javax.swing.JRadioButton rdoNamkh;
    private javax.swing.JRadioButton rdonunv;
    private javax.swing.JRadioButton rdonvnam;
    private javax.swing.JTable tbHodDonCTDVD;
    private javax.swing.JTable tbKH;
    private javax.swing.JTable tbTTDVDTT;
    private javax.swing.JTable tbTTThuePhong;
    private javax.swing.JTable tbTTThuePhongTT;
    private javax.swing.JTable tblDV;
    private javax.swing.JTable tblHoaDOn;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTable tblnhanvien;
    private javax.swing.JTextField txtDiaChiTT;
    private javax.swing.JTextField txtDiachinv;
    private javax.swing.JTextField txtDoanhThuTongNam;
    private javax.swing.JTextField txtDoanhThuTongNgay;
    private javax.swing.JTextField txtDoanhThuTongThang;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayCheckOutTT;
    private javax.swing.JTextField txtNgayCheckinTT;
    private javax.swing.JTextField txtNgaySinhTT;
    private javax.swing.JTextField txtSDTTT;
    private javax.swing.JTextField txtSearchKH;
    private javax.swing.JTextField txtSoCCCDTT;
    private javax.swing.JTextField txtSoHoaDonNam;
    private javax.swing.JTextField txtSoHoaDonThang;
    private javax.swing.JTextField txtSoNguoi;
    private com.toedter.calendar.JDateChooser txtTGThemDVD;
    private com.toedter.calendar.JDateChooser txtTGThue;
    private com.toedter.calendar.JDateChooser txtTGTra;
    private javax.swing.JTextField txtTang;
    private javax.swing.JTextField txtTangTT;
    private javax.swing.JTextField txtTenDV;
    private javax.swing.JTextField txtTenKHTT;
    private javax.swing.JTextField txtTenPhongTT;
    private javax.swing.JTextField txtTgThue;
    private javax.swing.JTextField txtTienPhong;
    private javax.swing.JTextField txtTienThanhToan;
    private javax.swing.JTextField txtTimKiemKhachHang;
    private javax.swing.JTextField txtTongTienPhong;
    private javax.swing.JTextField txtTongphiDV;
    private javax.swing.JTextField txtcccd;
    private javax.swing.JTextField txtcccdnv;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtdoanhthuNam;
    private javax.swing.JTextField txtdoanhthuThang;
    private javax.swing.JTextField txtdoanhthungay;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtgiatheogio;
    private javax.swing.JTextField txtgiatheongay;
    private javax.swing.JTextField txtmahdTT;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmaphong;
    private javax.swing.JTextField txtngaysinhkh;
    private javax.swing.JTextField txtngaysinhnv;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtsdtnv;
    private javax.swing.JTextField txtsohoadonngay;
    private javax.swing.JTextField txtsonguoitoida;
    private javax.swing.JTextField txttangTT;
    private javax.swing.JTextField txttenPhong;
    private javax.swing.JTextField txttenkh;
    private javax.swing.JTextField txttenkhTT;
    private javax.swing.JTextField txttennv;
    private javax.swing.JTextField txttenphongTT;
    private javax.swing.JTextField txttiendua;
    private javax.swing.JTextField txttienthua;
    private javax.swing.JTextField txttongtienTT;
    // End of variables declaration//GEN-END:variables

    //DIchVU
    public DichVu getformDV() {
//        int row = tblDV.getSelectedRow();
        DichVu dv = new DichVu();
        String madv = txtMaDV.getText();
        String tendv = txtTenDV.getText();
        float giaDv = Float.parseFloat(txtGia.getText());
        if (madv.trim().length() == 0
                || tendv.trim().length() == 0
                || txtGia.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Dịch Vụ Trống");
            return null;
        }

        try {
            if (Float.parseFloat(txtGia.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Giá Phải Lớn Hơn 0");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Phải Nhập Đúng Định Dạng SỐ");
            return null;
        }
        dv.setMaDichVu(madv);
        dv.setLoaiDichVu(tendv);
        dv.setPhiDichVu(giaDv);
        return dv;
    }

    private void clearFormDV() {
        txtGia.setText("");
        txtMaDV.setText("");
        txtTenDV.setText("");
    }

    public void loadTabledichvu() {
        List<DichVu> listdv = dichVuService.getAll();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblDV.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < listdv.size(); i++) {
            Object[] RowData = {
                i + 1,
                listdv.get(i).getMaDichVu(),
                listdv.get(i).getLoaiDichVu(),
                listdv.get(i).getPhiDichVu(),};
            defaultTableModel.addRow(RowData);
        }
    }

    private void loadHomePage() {
        try {
            List<Phong> listPhong = phongService.getAll();

            int width = getWidth();
            int heigth = getHeight();

            int padding = (width * 20 / 100 / 7) + 10;
            int widthRoomIcon = (width * 80 / 100) / 7;
            Image occuppiedImage = ImageIO.read(new File("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\occupied.png")).getScaledInstance(widthRoomIcon, widthRoomIcon, 1);
            ImageIcon occupiedIcon = new ImageIcon(occuppiedImage);

            Image availableImage = ImageIO.read(new File("C:\\Users\\ASUS\\Downloads\\DuAn1 Main\\DuAn1 Main\\DuAn1 Main\\src\\main\\java\\com\\mycompany\\img\\available.png")).getScaledInstance(widthRoomIcon, widthRoomIcon, 1);
            ImageIcon availableIcon = new ImageIcon(availableImage);
            for (int i = 0; i < listPhong.size(); i++) {

                if (listPhong.get(i).getTrangThai() == true) {  // Neu phong da cho thue (tu dien code)

                    int row = i / 6;
                    int col = i % 6;
                    JButton roomIcon = new JButton();
                    roomIcon.setIcon(occupiedIcon);
                    roomIcon.setBounds((padding + widthRoomIcon) * col + padding, (padding + widthRoomIcon) * row + padding, widthRoomIcon, widthRoomIcon);
                    roomIcon.setVisible(true);
                    JLabel roomNumber = new JLabel();

                    roomNumber.setText(listPhong.get(i).getTenPhong());
                    roomNumber.setSize(50, 30);
                    roomNumber.setForeground(Color.red);
                    roomNumber.setFont(new Font("Arial", Font.BOLD, 20));
                    roomNumber.setBounds((padding + widthRoomIcon) * col + padding - 20 + (widthRoomIcon) / 2, (padding + widthRoomIcon) * row + padding + widthRoomIcon, 100, 30);

                    roomNumber.setVisible(true);
                    Trangchu.add(roomIcon);
                    Trangchu.add(roomNumber);
                    roomIcon.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DatTra.setVisible(true);
                            DefaultTableModel defaultTableModel = (DefaultTableModel) tbKH.getModel();
                            defaultTableModel.setRowCount(0);
                            tbKH.removeAll();
                            lblTenP.setText(roomNumber.getText());
                            DatTra.setLocationRelativeTo(null);
                            cbbTenPhong.removeAllItems();
                            CBBtenPhong(phongService.getAll());
                            clearDatTra();
                            loadtttp();
                            loadTableDVD(dichVuDungService.getAll());
                        }
                    });

                } else {
                    int row = i / 6;
                    int col = i % 6;

                    JButton roomIcon = new JButton();
                    roomIcon.setIcon(availableIcon);
                    roomIcon.setBounds((padding + widthRoomIcon) * col + padding, (padding + widthRoomIcon) * row + padding, widthRoomIcon, widthRoomIcon);
                    roomIcon.setVisible(true);
                    JLabel roomNumber = new JLabel();
                    roomNumber.setText(listPhong.get(i).getTenPhong());
                    roomNumber.setSize(50, 30);
                    roomNumber.setForeground(Color.GREEN);
                    roomNumber.setFont(new Font("Arial", Font.BOLD, 20));
                    roomNumber.setBounds((padding + widthRoomIcon) * col + padding - 20 + (widthRoomIcon) / 2, (padding + widthRoomIcon) * row + padding + widthRoomIcon, 100, 30);
                    Trangchu.add(roomIcon);
                    Trangchu.add(roomNumber);

                    roomIcon.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DatTra.setVisible(true);
                            DefaultTableModel defaultTableModel = (DefaultTableModel) tbKH.getModel();
                            defaultTableModel.setRowCount(0);
                            tbKH.removeAll();
                            lblTenP.setText(roomNumber.getText());
                            DatTra.setLocationRelativeTo(null);
                            cbbTenPhong.removeAllItems();
                            CBBtenPhong(phongService.getAll());
                            clearDatTra();
                            loadtttp();
                            loadTableDVD(dichVuDungService.getAll());
                        }
                    }
                    );

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(QLKS.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    //loadTTtphong
    public void loadtttp() {
        DefaultTableModel dtm = (DefaultTableModel) tbTTThuePhong.getModel();
        dtm.setRowCount(0);

        List<ThongTinThuePhong> listp = ti.getAll();
        for (ThongTinThuePhong thongTinThuePhong : listp) {
            if (thongTinThuePhong.getPhong().getTrangThai() == true) {
                if (thongTinThuePhong.getPhong().getTenPhong().equals(cbbTenPhong.getSelectedItem().toString())) {
                    Object[] row = new Object[7];
                    row[0] = thongTinThuePhong.getPhong().getTang();
                    row[1] = thongTinThuePhong.getPhong().getTenPhong();
                    row[2] = thongTinThuePhong.getKhachHang().getHoVaTen();
                    row[3] = thongTinThuePhong.getHinhThucThue();
                    row[4] = thongTinThuePhong.getThoiGianThue();
                    row[5] = thongTinThuePhong.getThoiGianTra();
                    row[6] = thongTinThuePhong.getSoNguoi();
                    dtm.addRow(row);
                }
            }
        }
    }

    private void CBBtenPhong(List<com.mycompany.Domainmodels.Phong> list) {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbbTenPhong.getModel();
        for (com.mycompany.Domainmodels.Phong x : list) {
            if (x.getTenPhong().equalsIgnoreCase(lblTenP.getText())) {
                dcm.addElement(x);
            }
        }
    }
    //load cbbDV

    private void loadCBBDichVu(List<DichVu> list) {
        dcm = (DefaultComboBoxModel) cbbDV.getModel();
        for (DichVu dichVu : list) {
            dcm.addElement(dichVu);
        }
    }

//    
    private void loadTableDVD(List<DichVuDung> listDVD) {
        DefaultTableModel model = (DefaultTableModel) tbHodDonCTDVD.getModel();
        model.setRowCount(0);
        int i = 1;
        for (DichVuDung hdctdvd : listDVD) {
            if (hdctdvd.getPhong().getTrangThai() == true) {
                if (hdctdvd.getPhong().getTenPhong().equals(cbbTenPhong.getSelectedItem().toString())) {
                    Object[] row = new Object[6];
                    row[0] = i++;
                    row[1] = hdctdvd.getPhong().getTenPhong();
                    row[2] = hdctdvd.getDichVu().getLoaiDichVu();
                    row[3] = hdctdvd.getSoLuongSuDung();
                    row[4] = hdctdvd.getNgayThue();
                    row[5] = hdctdvd.getSoLuongSuDung() * hdctdvd.getDichVu().getPhiDichVu();
                    model.addRow(row);

                }
            }
        }

    }
//loadManThanhToan

    public void LoadTTThanhtoan() {
        List<ThongTinThuePhong> listttp = ti.getAll();

        dtm = (DefaultTableModel) tbTTThuePhongTT.getModel();
        dtm.setRowCount(0);

        for (ThongTinThuePhong tttp : listttp) {
            if (tttp.getPhong().getTenPhong().equals(cbbTenPhong.getSelectedItem().toString())) {
                txtNgayCheckinTT.setText(tttp.getThoiGianThue().toString());
                txtNgayCheckOutTT.setText(tttp.getThoiGianTra().toString());
                txtTenKHTT.setText(tttp.getKhachHang().getHoVaTen());
                txtSDTTT.setText(tttp.getKhachHang().getsDT());
                if (tttp.getKhachHang().getGioiTinh().equals("Nam")) {
                    cbbGioiTinhTT.setSelectedItem("Nam");
                } else {
                    cbbGioiTinhTT.setSelectedItem("Nu");
                }
                txtNgaySinhTT.setText(tttp.getKhachHang().getNgaySinh().toString());
                txtDiaChiTT.setText(tttp.getKhachHang().getDiaChi());
                txtSoCCCDTT.setText(tttp.getKhachHang().getsCCCD());
                txtsdt.setText(tttp.getKhachHang().getsDT());
                cbbHinhThucThueTT.setSelectedItem(tttp.getHinhThucThue());
                txtTenPhongTT.setText(tttp.getPhong().getTenPhong());
                txtTangTT.setText(String.valueOf(tttp.getPhong().getTang()));

                Object[] row = new Object[6];
                row[0] = tttp.getThoiGianThue();
                row[1] = tttp.getThoiGianTra();
                row[2] = tttp.getHinhThucThue();
                if (tttp.getHinhThucThue().equals("Thue theo gio")) {
                    row[3] = tttp.getPhong().getGiaTheoGio();
                    row[4] = (tttp.getThoiGianTra().getTime() - tttp.getThoiGianThue().getTime()) / (150000 * 24);
                    row[5] = tttp.getPhong().getTang();
                    dtm.addRow(row);
                    return;
                }
                row[3] = tttp.getPhong().getGiaTheoNgay();
                row[4] = (tttp.getThoiGianTra().getTime() - tttp.getThoiGianThue().getTime()) / (150000 * 24 * 24);
                row[5] = tttp.getPhong().getTang();
                dtm.addRow(row);

            }
        }

//        for (ThongTinThuePhong thongTinThuePhong : listttp) {
//            if (thongTinThuePhong.getPhong().getTenPhong().equals(cbbTenPhong.getSelectedItem())) {
//                
//
//            } else {
//                return;
//            }
//        }
        DefaultTableModel dt = (DefaultTableModel) tbTTDVDTT.getModel();
        dt.setRowCount(0);
        List<DichVuDung> listdvd = dichVuDungService.getAll();
        for (DichVuDung x : listdvd) {
            if (x.getPhong().getTenPhong().equals(cbbTenPhong.getSelectedItem())) {
                dt.addRow(new Object[]{
                    x.getDichVu().getLoaiDichVu(), x.getNgayThue(), x.getDichVu().getPhiDichVu()});
            }
        }

    }

    public float getThanhTien(String ma) {
        float money = 0;
        List<DichVuDung> list = dichVuDungService.getAll();
        for (DichVuDung dvd : list) {
            if (dvd.getPhong().getTenPhong().equals(ma)) {
                money += (dvd.getDichVu().getPhiDichVu() * dvd.getSoLuongSuDung());
            }
        }
        return money;
    }

    //hd
    public HoaDon getHoadon() {
        Random rd = new Random();
        int rdnumber = rd.nextInt(1, 1000);
        String maHd = "HD" + rdnumber;
        return new HoaDon(maHd);
    }

    public void loadHoaDon(List<HoaDon> list) {
        dtm = (DefaultTableModel) tblHoaDOn.getModel();
        dtm.setRowCount(0);
        int i = 0;

        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{
                dtm.getRowCount() + 1, hd.getMa(), hd.getKhachHang().getHoVaTen(), hd.getNgayTao(), hd.getNgayTraPhong(),
                hd.getThongTinThuePhong().getPhong().getTenPhong(), hd.getThongTinThuePhong().getPhong().getTang(),
                numberFM.format(hd.getTongTien()), hd.getTinhTrang()
            });
        }
    }

    //getPhong
    public void getPhong(String ten) {
        List<Phong> listp = phongService.getAll();
        for (Phong p : listp) {
            if (p.getTenPhong().equals(ten)) {
                phongService.UpdateTinhTrangcontrong(p, ten);
                loadPhong(listp);
                return;
            }
        }
    }

    public void clearDatTra() {
        txtSearchKH.setText("");
        tbTTThuePhong.removeAll();
        tbHodDonCTDVD.removeAll();
        tbKH.removeAll();
//        txtTGThue.setDate(Date.valueOf(""));
//        txtTGTra.setDate(Date.valueOf(""));
        txtSoNguoi.setText("");
    }

    private void loadDVDTT(List<DichVuDung> list) {
        dtm = (DefaultTableModel) tbTTDVDTT.getModel();
        dtm.setRowCount(0);
        for (DichVuDung x : list) {
            if (x.getPhong().getTenPhong().equals(txtTenPhongTT.getText())) {
                dtm.addRow(new Object[]{
                    x.getDichVu().getLoaiDichVu(), x.getNgayThue(), x.getDichVu().getPhiDichVu() * x.getSoLuongSuDung()
                });
            }
        }
    }

    private void loadHoaDonView(List<ThongTinHoaDon> li) {
        dtm = (DefaultTableModel) tblHoaDOn.getModel();
        dtm.setRowCount(0);
        for (ThongTinHoaDon x : li) {
            dtm.addRow(new Object[]{
                dtm.getRowCount() + 1,
                x.getMa(), x.getTenKhachHang(),
                x.getNgayTao(), x.getNgayTraPhong(), x.getTenPhong(), x.getTang(),
                x.getTongTien(),
                x.getTinhTrang()
            });
        }
    }

    public ThongTinHoaDon getFormDataHDV() {
        int r = tblHoaDOn.getSelectedRow();
        String maHDV = tblHoaDOn.getValueAt(r, 1).toString();
        String TenKH = tblHoaDOn.getValueAt(r, 2).toString();
        Date ngayCHeckin = Date.valueOf(tblHoaDOn.getValueAt(r, 3).toString());
        Date ngayCHeckout = Date.valueOf(tblHoaDOn.getValueAt(r, 4).toString());
        String TenPhong = txttenphongTT.getText().trim();
        int Tang = Integer.parseInt(txttangTT.getText());
        float tongTien = Float.parseFloat(txttongtienTT.getText());
        String TrangThai = tblHoaDOn.getValueAt(r, 8).toString();

        return new ThongTinHoaDon(maHDV, ngayCHeckin, ngayCHeckout, TrangThai, TenKH, Tang, TenPhong, tongTien);
    }
}
