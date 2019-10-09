namespace java io.github.hepan.rpc.thrift

service JazzService{
    bool exists(1:string path)

    User findUser(1:i64 id)
}

struct User{
    i64 timestamp,
    string name,
    i64 id,
    bool vip
}