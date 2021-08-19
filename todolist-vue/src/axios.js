import axios from "axios";

axios.defaults.baseURL='http://localhost:8090'

axios.interceptors.request.use(config => {
    return config
})