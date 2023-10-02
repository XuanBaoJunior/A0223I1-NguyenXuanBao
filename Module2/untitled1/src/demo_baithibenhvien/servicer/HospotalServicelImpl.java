package demo_baithibenhvien.servicer;

import demo_baithibenhvien.controller.HospitalController;
import demo_baithibenhvien.model.Doctor;
import demo_baithibenhvien.model.Patient;
import demo_baithibenhvien.repository.DoctorRepository;
import demo_baithibenhvien.repository.PatientRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HospotalServicelImpl implements Service {
    DoctorRepository doctorRepository = new DoctorRepository();
    PatientRepository patientRepository = new PatientRepository();
    Scanner scanner = new Scanner(System.in);
    List<Doctor> doctorList = doctorRepository.readDoctorToFile();
    List<Patient> patientList = patientRepository.readPatientToFile();
    HospitalController hospitalController = new HospitalController();
    int nextID = 1;

    private int generateNextDoctorID() {
        int maxID = 0;
        for (Doctor doctor : doctorList) {
            if (doctor.getId() > maxID) {
                maxID = doctor.getId();
            }
        }
        return maxID + 1;
    }

    private int generateNextPatientID() {
        int maxID = 0;
        for (Patient patient : patientList) {
            if (patient.getId() > maxID) {
                maxID = patient.getId();
            }
        }
        return maxID + 1;
    }

    @Override
    public void display() {
        doctorList = doctorRepository.readDoctorToFile();
        patientList = patientRepository.readPatientToFile();
        System.out.println("Danh sach bac si");
        for (Doctor dtList : doctorList) {
            System.out.println(dtList.toString());
        }
        System.out.println("Danh sach benh nhan");
        for (Patient paList : patientList) {
            System.out.println(paList.toString());
        }
    }

    @Override
    public void add() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan \n" +
                        "1. Danh sach bac si \n" +
                        "2. Danh sach benh nhan \n" +
                        "3. Back to menu "
                );
                System.out.println("Chọn chức năng ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        addDSDoctor();
                        break;
                    case 2:
                        addDSPatient();
                        break;
                    case 3:
                        hospitalController.displayHospotalMenu();
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();

            } catch (NumberFormatException ex) {
                System.out.println("Mời bạn nhập lại chức năng");
                scanner.nextLine();
            }
        }
    }

    private void addDSPatient() {
        Patient patient = new Patient();
        patient.setId(generateNextPatientID());

        System.out.println("Nhập tên bệnh nhân:");
        String patientName = scanner.nextLine();
        while (!isValidName(patientName)) {
            System.out.println("Tên không hợp lệ. Vui lòng nhập lại tên giáo viên:");
            patientName = scanner.nextLine();
        }
        patient.setName(patientName);

        String gioiTinh;
        do {
            System.out.println("Nhập giới tính (nam/nữ):");
            gioiTinh = scanner.nextLine();
        } while (!isValidGioiTinh(gioiTinh));
        patient.setGioiTinh(gioiTinh);

        int cccd;
        do {
            System.out.println("Nhập số CCCD (8 chữ số):");
            String cccdStr = scanner.nextLine();
            if (isValidCCCD(cccdStr)) {
                cccd = Integer.parseInt(cccdStr);
            } else {
                System.out.println("Số CCCD không hợp lệ. Vui lòng nhập lại.");
                cccd = -1;
            }
        } while (cccd == -1);
        patient.setCccd(cccd);

        System.out.println("Nhập thẻ BHYT");
        patient.setBaoHiemYTe(scanner.nextLine());

        System.out.println("Nhập bệnh án");
        patient.setBenhAn(scanner.nextLine());

        Date ngayNhapVien;
        do {
            System.out.println("Nhập ngày nhập viện (yyyy-MM-dd):");
            String ngayNhapVienStr = scanner.nextLine();
            ngayNhapVien = parseDate(ngayNhapVienStr);
        } while (ngayNhapVien == null);
        patient.setNgayNhapVien(ngayNhapVien);

        Date ngayRaVien;
        do {
            System.out.println("Nhập ngày ra viện (yyyy-MM-dd):");
            String ngayRaVienStr = scanner.nextLine();
            ngayRaVien = parseDate(ngayRaVienStr);
        } while (ngayRaVien == null);
        patient.setNgayRaVien(ngayRaVien);

        patientList.add(patient);
        patientRepository.writePatientCSV(patientList);
        System.out.println("Bệnh nhân đã được thêm mới");
    }

    private boolean isValidName(String name) {
        return name.matches("[A-Za-z\\s]+");
    }

    private boolean isValidGioiTinh(String gioiTinh) {
        return gioiTinh.equalsIgnoreCase("nam") || gioiTinh.equalsIgnoreCase("nữ");
    }

    private boolean isValidCCCD(String cccdStr) {
        return cccdStr.matches("\\d{8}");
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    private void addDSDoctor() {
        Doctor doctor = new Doctor();
        doctor.setId(generateNextDoctorID());


    }


    @Override
    public void update() {

    }

    @Override
    public void remove() {

    }
}
