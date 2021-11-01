import axios from "axios";

axios.defaults.baseURL='http://121.5.168.45:8888'

axios.interceptors.request.use(config => {
    return config
})
