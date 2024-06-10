package nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs;

public record ApiResponse<T>(String message, T data) {
}
