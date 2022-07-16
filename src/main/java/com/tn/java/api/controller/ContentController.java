package com.tn.java.api.controller;

import com.tn.java.api.core.CoreUtility;
import com.tn.java.api.core.Response;
import com.tn.java.api.model.ContentDB;
import com.tn.java.api.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/content")
public class ContentController {

	@Autowired
	private CoreUtility coreUtility;

	@Autowired
	private ContentService contentService;

	@PostMapping("/upload")
	public Response Post(@RequestParam("file") MultipartFile file) throws IOException {
		if(coreUtility.isNotNull(file)){
			contentService.upToDB(file);
		}
		return Response.success();
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> Get(@PathVariable String id) {
		ContentDB fileDB = contentService.download(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}

}
