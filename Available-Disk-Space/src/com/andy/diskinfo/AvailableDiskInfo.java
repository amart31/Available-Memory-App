package com.andy.diskinfo;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;


public class AvailableDiskInfo {
	public static void main(String[] args) {
		
		FileSystem fileSystem = FileSystems.getDefault();
		
		System.out.println("%30s  | %10s | %20s | %20s \\n\", \"\", \"TYPE\", \"TOTAL SPACE\", \"FREE SPACE\"");
		System.out.println("-------------------------------------------------"
				+ "----------------------------------------------------------");
		
		Iterable<FileStore> iterable = fileSystem.getFileStores();
		iterable.forEach(s -> {
			try {
				
				System.out.printf("%40s | %20s | %20s | %20s \n", s, s.type(), (s.getTotalSpace() / 1073741824f) + " GB", (s.getUsableSpace() / 1073741824f) + "GB");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
