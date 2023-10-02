package demo_baithibenhvien1.servicer;


import demo_baithibenhvien1.controller.HospitalController;
import demo_baithibenhvien1.model.Doctor;
import demo_baithibenhvien1.model.Patient;
import demo_baithibenhvien1.repository.DoctorRepository;
import demo_baithibenhvien1.repository.PatientRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HospotalServicerImpl implements Servicer{
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
    private boolean isValidName(String name) {
        return name.matches("[A-Za-z\\s]+");
    }

    private boolean isValidGioiTinh(String gioiTinh) {
        return gioiTinh.equalsIgnoreCase("nam") || gioiTinh.equalsIgnoreCase("nữ");
    }

    private boolean isValidCCCD(String cccdStr) {
        return cccdStr.matches("\\d{8}");
    }

    private void addDSPatient() {
        Patient patient = new Patient();
        patient.setId(generateNextPatientID());

        System.out.println("Nhập tên bệnh nhân:");
        String patientName = scanner.nextLine();
        while (!isValidName(patientName)) {
            System.out.println("Tên không hợp lệ. Vui lòng nhập lại tên bệnh nhân:");
            patientName = scanner.nextLine();
        }
        patient.setName(patientName);

        String gioiTinh;
        do {
            System.out.println("Nhập giới tính (nam/nữ):");
            gioiTinh = scanner.nextLine();
        } while (!isValidGioiTinh(gioiTinh));
        patient.setGioiTinh(gioiTinh);
        String cccdStr;
        do {
            System.out.println("Nhập số CCCD (8 chữ số):");
            cccdStr = scanner.nextLine();
            if (isValidCCCD(cccdStr)) {
                patient.setCccd(cccdStr);
            } else {
                System.out.println("Số CCCD không hợp lệ. Vui lòng nhập lại.");
                cccdStr = null;
            }
        } while (cccdStr == null);
        System.out.println("Nhập thẻ BHYT");
        patient.setBaoHiemYTe(scanner.nextLine());

        System.out.println("Nhập bệnh án");
        patient.setBenhAn(scanner.nextLine());

        System.out.println("Ngày nhập viện");
        patient.setNgayNhapVien(scanner.nextLine());

        System.out.println("Ngày ra viện");
        patient.setNgayRaVien(scanner.nextLine());

    }

    private void addDSDoctor() {
        Doctor doctor = new Doctor();
        doctor.setId(generateNextDoctorID());

        System.out.println("Nhập tên bác sĩ");
        String doctorName = scanner.nextLine();
        while (!isValidName(doctorName)) {
            System.out.println("Tên không hợp lệ. Vui lòng nhập lại tên bác sĩ:");
            doctorName = scanner.nextLine();
        }
        doctor.setName(doctorName);
        String gioiTinh;
        do {
            System.out.println("Nhập giới tính (nam/nữ):");
            gioiTinh = scanner.nextLine();
        } while (!isValidGioiTinh(gioiTinh));
        doctor.setGioiTinh(gioiTinh);
        String cccdStr;

        System.out.println("Nhập SDT: ");
        String sdt = readValidPhoneNumber(scanner);
        doctor.setSdt(sdt);

        System.out.println("Nhập chức vụ: ");
        scanner.nextLine();
        doctor.setChucVu(scanner.nextLine());

        System.out.println("Nhập khoa bệnh: ");
        doctor.setKhoaBenh(scanner.nextLine());

        System.out.println("Nhập lương: ");
        doctor.setSalary(scanner.nextDouble());
    }
    public static String readValidPhoneNumber(Scanner scanner) {
        String phoneNumber;
        do {
            phoneNumber = scanner.next();
            if (phoneNumber.length() != 10 || !phoneNumber.startsWith("0")) {
                System.out.println("SDT không hợp lệ bắt buộc số kí tự đầu tiên là số 0 và SDT có 10 số. Vui lòng nhập lại.");
            }
        } while (phoneNumber.length() != 10 || !phoneNumber.startsWith("0"));

        return phoneNumber;
    }

    @Override
    public void remove() {
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Danh sach thanh phan\n" +
                        "1. Danh sach sinh vien\n" +
                        "2. Danh sach giao vien\n" +
                        "3. Back to menu"
                );
                System.out.println("Chọn chức năng");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        removeDSDoctor();
                        break;
                    case 2:
                        removeDSPatient();
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

    private void removeDSPatient() {
    }

    private void removeDSDoctor() {

    }
    public Doctor getDoctorById(int doctorId) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }public Patient getPatientById(int patientId) {
        for (Patient patient : patientList) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }
    @Override
    public void update() {
        System.out.println("Nhập ID của đối tượng bạn muốn cập nhật:");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Bạn muốn cập nhật thông tin của bệnh nhân hay bác sĩ? (patient/doctor)");
        String objectType = scanner.nextLine();

        if ("patient".equals(objectType)) {
            updatePatient(idToUpdate);
        } else if ("doctor".equals(objectType)) {
            updateDoctor(idToUpdate);
        } else {
            System.out.println("Loại đối tượng không hợp lệ.");
        }
    }

    private void updateDoctor(int doctorId) {
        Doctor doctorToUpdate = getDoctorById(doctorId);

        if (doctorToUpdate == null) {
            System.out.println("Không tìm thấy bác sĩ với ID đã cho.");
            return;
        }

        System.out.println("Nhập tên bác sĩ mới:");
        String newDoctorName = scanner.nextLine();
        if (isValidName(newDoctorName)) {
            doctorToUpdate.setName(newDoctorName);
        } else {
            System.out.println("Tên không hợp lệ.");
        }

        System.out.println("Nhập giới tính mới (nam/nữ):");
        String newGioiTinh = scanner.nextLine();
        if (isValidGioiTinh(newGioiTinh)) {
            doctorToUpdate.setGioiTinh(newGioiTinh);
        } else {
            System.out.println("Giới tính không hợp lệ.");
        }


        System.out.println("Nhập SDT mới: ");
        String newSdt = readValidPhoneNumber(scanner);
        doctorToUpdate.setSdt(newSdt);

        System.out.println("Nhập chức vụ mới: ");
        String newChucVu = scanner.nextLine();
        doctorToUpdate.setChucVu(newChucVu);

        System.out.println("Nhập khoa bệnh mới: ");
        String newKhoaBenh = scanner.nextLine();
        doctorToUpdate.setKhoaBenh(newKhoaBenh);

        System.out.println("Nhập lương mới: ");
        double newSalary = scanner.nextDouble();
        doctorToUpdate.setSalary(newSalary);
    }

    private void updatePatient(int patientId) {
        Patient patientToUpdate = getPatientById(patientId);

        if (patientToUpdate == null) {
            System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
            return;
        }

        System.out.println("Nhập tên bệnh nhân mới:");
        String newName = scanner.nextLine();
        if (isValidName(newName)) {
            patientToUpdate.setName(newName);
        } else {
            System.out.println("Tên không hợp lệ.");
        }

        System.out.println("Nhập giới tính mới (nam/nữ):");
        String newGioiTinh = scanner.nextLine();
        if (isValidGioiTinh(newGioiTinh)) {
            patientToUpdate.setGioiTinh(newGioiTinh);
        } else {
            System.out.println("Giới tính không hợp lệ.");
        }
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
}
