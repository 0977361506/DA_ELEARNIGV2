package com.vnpost.e_learning.service;

import java.util.List;

import com.vnpost.e_learning.entities.Document;

public interface IDocumentService {
	public List<Document> getListDocuments();
	public Document findById(long id);
	public List<Document> getListDocumentsFromCategory(Long id);
	public List<Document> getListFindByName(String a);
}
