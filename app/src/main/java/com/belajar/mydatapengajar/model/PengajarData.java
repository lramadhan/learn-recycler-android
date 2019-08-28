package com.belajar.mydatapengajar.model;

import java.util.ArrayList;

public class PengajarData {
    public static String[][] data = new String[][]{
            {"Dikdik Imanudin","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/men/88.jpg"},
            {"Luqman Hakim","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/men/81.jpg"},
            {"Pebi Pebriadi","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/men/1.jpg"},
            {"Yayan Supriatna","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/men/3.jpg"},
            {"Iwan Setiawan","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/men/8.jpg"},
            {"Muchamad Sidik","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/men/78.jpg"},
            {"Andri Andriyan","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/men/6.jpg"},
            {"Hj. Ade Sri Mutiara","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/women/18.jpg"},
            {"Aan Tisnawati","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/women/8.jpg"},
            {"N. Rosyaningsih","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/women/6.jpg"},
            {"Euis Sartika","TKJ \n Jl. Noenoeng Tisnasaputra, Kahuripan, Tawang - Tasikmalaya 46115 ","https://randomuser.me/api/portraits/women/7.jpg"},
    };

    public static ArrayList<Pengajar> getListData() {
        ArrayList<Pengajar> list = new ArrayList<>();
        for (String[] aData : data) {
            Pengajar pengajar = new Pengajar();
            pengajar.setName(aData[0]);
            pengajar.setDescription(aData[1]);
            pengajar.setPhoto(aData[2]);

            list.add(pengajar);
        }

        return list;
    }
}
