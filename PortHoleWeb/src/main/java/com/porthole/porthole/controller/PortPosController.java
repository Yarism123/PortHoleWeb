package com.porthole.porthole.controller;

import com.google.gson.Gson;
import com.porthole.porthole.entity.MarkerForm;
import com.porthole.porthole.entity.PortPos;
import com.porthole.porthole.service.PortPosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PortPosController {

    private final PortPosService portPosService;
    private final SimpMessagingTemplate messagingTemplate;

    @Value(("${google.maps.api-key}"))
    private String api_key;

    @Value(("${raspi.url.video}"))
    private String server_url;

    @GetMapping("/map")
    public String map(Model model) {
        List<PortPos> mapPos = portPosService.findAll();
        model.addAttribute("mapPos", mapPos);
        return "map";
    }

    @GetMapping("/video")
    public String video(Model model) {
        model.addAttribute("server_url", server_url);
        return "video";
    }

    /**
     * @Json
     * {
     *     "latitude": 37.20963,
     *     "longitude": 126.9790
     * }
     * */
    @PostMapping("/addMarker")
    public ResponseEntity<String> addMarker(@RequestBody Map<String, Double> coordinates) {
        double latitude = coordinates.get("latitude");
        double longitude = coordinates.get("longitude");

        PortPos portPos = new PortPos(latitude, longitude);
        portPosService.save(portPos);

        // 연결된 모든 클라이언트에게 마커 정보 추가
        messagingTemplate.convertAndSend("/topic/markers", portPos);

        return ResponseEntity.ok("Marker added successfully");
    }
}