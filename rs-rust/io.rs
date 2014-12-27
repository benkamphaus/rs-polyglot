fn main() {
    // how not to do it in rust
    use std::io::File;

    let mut file = File::open(&Path::new("../rs-clj/data/nireland.dat"));
    let mut vec = Vec::new();

    for i in range(0i, 41203711i) {
        vec.push(file.read_le_i16().unwrap());
    }
}
