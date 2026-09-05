package com.horis.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\bHÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/horis/cncverse/NewTvOtpResponse;", "", "otp", "", "status", "usertoken", "pub_msg", "pub_msg_f_size", "", "pub_msg_color", "error_msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getOtp", "()Ljava/lang/String;", "getStatus", "getUsertoken", "getPub_msg", "getPub_msg_f_size", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPub_msg_color", "getError_msg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/horis/cncverse/NewTvOtpResponse;", "equals", "", "other", "hashCode", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NewTvOtpResponse {

    @Nullable
    private final String error_msg;

    @Nullable
    private final String otp;

    @Nullable
    private final String pub_msg;

    @Nullable
    private final String pub_msg_color;

    @Nullable
    private final Integer pub_msg_f_size;

    @Nullable
    private final String status;

    @Nullable
    private final String usertoken;

    public NewTvOtpResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NewTvOtpResponse copy$default(NewTvOtpResponse newTvOtpResponse, String str, String str2, String str3, String str4, Integer num, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newTvOtpResponse.otp;
        }
        if ((i & 2) != 0) {
            str2 = newTvOtpResponse.status;
        }
        if ((i & 4) != 0) {
            str3 = newTvOtpResponse.usertoken;
        }
        if ((i & 8) != 0) {
            str4 = newTvOtpResponse.pub_msg;
        }
        if ((i & 16) != 0) {
            num = newTvOtpResponse.pub_msg_f_size;
        }
        if ((i & 32) != 0) {
            str5 = newTvOtpResponse.pub_msg_color;
        }
        if ((i & 64) != 0) {
            str6 = newTvOtpResponse.error_msg;
        }
        String str7 = str5;
        String str8 = str6;
        Integer num2 = num;
        String str9 = str3;
        return newTvOtpResponse.copy(str, str2, str9, str4, num2, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOtp() {
        return this.otp;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUsertoken() {
        return this.usertoken;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPub_msg() {
        return this.pub_msg;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getPub_msg_f_size() {
        return this.pub_msg_f_size;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPub_msg_color() {
        return this.pub_msg_color;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getError_msg() {
        return this.error_msg;
    }

    @NotNull
    public final NewTvOtpResponse copy(@Nullable String otp, @Nullable String status, @Nullable String usertoken, @Nullable String pub_msg, @Nullable Integer pub_msg_f_size, @Nullable String pub_msg_color, @Nullable String error_msg) {
        return new NewTvOtpResponse(otp, status, usertoken, pub_msg, pub_msg_f_size, pub_msg_color, error_msg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewTvOtpResponse)) {
            return false;
        }
        NewTvOtpResponse newTvOtpResponse = (NewTvOtpResponse) other;
        return Intrinsics.areEqual(this.otp, newTvOtpResponse.otp) && Intrinsics.areEqual(this.status, newTvOtpResponse.status) && Intrinsics.areEqual(this.usertoken, newTvOtpResponse.usertoken) && Intrinsics.areEqual(this.pub_msg, newTvOtpResponse.pub_msg) && Intrinsics.areEqual(this.pub_msg_f_size, newTvOtpResponse.pub_msg_f_size) && Intrinsics.areEqual(this.pub_msg_color, newTvOtpResponse.pub_msg_color) && Intrinsics.areEqual(this.error_msg, newTvOtpResponse.error_msg);
    }

    public int hashCode() {
        return ((((((((((((this.otp == null ? 0 : this.otp.hashCode()) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.usertoken == null ? 0 : this.usertoken.hashCode())) * 31) + (this.pub_msg == null ? 0 : this.pub_msg.hashCode())) * 31) + (this.pub_msg_f_size == null ? 0 : this.pub_msg_f_size.hashCode())) * 31) + (this.pub_msg_color == null ? 0 : this.pub_msg_color.hashCode())) * 31) + (this.error_msg != null ? this.error_msg.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NewTvOtpResponse(otp=" + this.otp + ", status=" + this.status + ", usertoken=" + this.usertoken + ", pub_msg=" + this.pub_msg + ", pub_msg_f_size=" + this.pub_msg_f_size + ", pub_msg_color=" + this.pub_msg_color + ", error_msg=" + this.error_msg + ')';
    }

    public NewTvOtpResponse(@Nullable String otp, @Nullable String status, @Nullable String usertoken, @Nullable String pub_msg, @Nullable Integer pub_msg_f_size, @Nullable String pub_msg_color, @Nullable String error_msg) {
        this.otp = otp;
        this.status = status;
        this.usertoken = usertoken;
        this.pub_msg = pub_msg;
        this.pub_msg_f_size = pub_msg_f_size;
        this.pub_msg_color = pub_msg_color;
        this.error_msg = error_msg;
    }

    public /* synthetic */ NewTvOtpResponse(String str, String str2, String str3, String str4, Integer num, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
    }

    @Nullable
    public final String getOtp() {
        return this.otp;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getUsertoken() {
        return this.usertoken;
    }

    @Nullable
    public final String getPub_msg() {
        return this.pub_msg;
    }

    @Nullable
    public final Integer getPub_msg_f_size() {
        return this.pub_msg_f_size;
    }

    @Nullable
    public final String getPub_msg_color() {
        return this.pub_msg_color;
    }

    @Nullable
    public final String getError_msg() {
        return this.error_msg;
    }
}
