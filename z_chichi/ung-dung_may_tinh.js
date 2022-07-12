let nhapsolan1, toantu, nhapsolan2;

// nhập gtri cho toán hạn (nhập số lân 1, 2)
function inputkqnhapso(number) {
    if (toantu) {
        nhapsolan1 = number;
    } else {
        nhapsolan2 = number
    }
}

// hàm nhập toán tử (toantu)
function inputtoantu(Operator) {
    toantu = Operator
}

// hàm xoá làm lại từ đầu
function xoa(undefined) {
    nhapsolan1 = undefined
    toantu = undefined
    nhapsolan2 = undefined
}

// thực hiện tính toán
function tinhtoan() {
    let ketqua;
    switch (toantu) {
        case `+`:
            ketqua = nhapsolan1 + nhapsolan2
            break;
        case `-`:
            ketqua = nhapsolan1 - nhapsolan2
            break;
        case `*`:
            ketqua = nhapsolan1 * nhapsolan2
            break;
        case `/`:
            ketqua = nhapsolan1 / nhapsolan2
            break;
    }
    document.getElementById(`ketqua`).innerHTML = ketqua
    // alert(`keets quả=`+ ketqua)
// }