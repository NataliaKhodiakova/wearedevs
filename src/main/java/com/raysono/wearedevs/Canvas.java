package com.raysono.wearedevs;
import lombok.Data;

import java.util.List;

@Data
public class Canvas {
    private int width;
    private int height;
    private List<int[]> coords;

}
