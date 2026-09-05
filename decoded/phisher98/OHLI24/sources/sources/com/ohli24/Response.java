package com.ohli24;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OHLI24/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/ohli24/Response;", "", "hls", "", "videoImage", "", "videoSource", "securedLink", "downloadLinks", "", "attachmentLinks", "ck", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getHls", "()Z", "getVideoImage", "()Ljava/lang/String;", "getVideoSource", "getSecuredLink", "getDownloadLinks", "()Ljava/util/List;", "getAttachmentLinks", "getCk", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "OHLI24"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Response {

    @NotNull
    private final List<Object> attachmentLinks;

    @NotNull
    private final String ck;

    @NotNull
    private final List<Object> downloadLinks;
    private final boolean hls;

    @NotNull
    private final String securedLink;

    @NotNull
    private final String videoImage;

    @NotNull
    private final String videoSource;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, boolean z, String str, String str2, String str3, List list, List list2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = response.hls;
        }
        if ((i & 2) != 0) {
            str = response.videoImage;
        }
        if ((i & 4) != 0) {
            str2 = response.videoSource;
        }
        if ((i & 8) != 0) {
            str3 = response.securedLink;
        }
        if ((i & 16) != 0) {
            list = response.downloadLinks;
        }
        if ((i & 32) != 0) {
            list2 = response.attachmentLinks;
        }
        if ((i & 64) != 0) {
            str4 = response.ck;
        }
        List list3 = list2;
        String str5 = str4;
        List list4 = list;
        String str6 = str2;
        return response.copy(z, str, str6, str3, list4, list3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHls() {
        return this.hls;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVideoImage() {
        return this.videoImage;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVideoSource() {
        return this.videoSource;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSecuredLink() {
        return this.securedLink;
    }

    @NotNull
    public final List<Object> component5() {
        return this.downloadLinks;
    }

    @NotNull
    public final List<Object> component6() {
        return this.attachmentLinks;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCk() {
        return this.ck;
    }

    @NotNull
    public final Response copy(boolean hls, @NotNull String videoImage, @NotNull String videoSource, @NotNull String securedLink, @NotNull List<? extends Object> downloadLinks, @NotNull List<? extends Object> attachmentLinks, @NotNull String ck) {
        return new Response(hls, videoImage, videoSource, securedLink, downloadLinks, attachmentLinks, ck);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return this.hls == response.hls && Intrinsics.areEqual(this.videoImage, response.videoImage) && Intrinsics.areEqual(this.videoSource, response.videoSource) && Intrinsics.areEqual(this.securedLink, response.securedLink) && Intrinsics.areEqual(this.downloadLinks, response.downloadLinks) && Intrinsics.areEqual(this.attachmentLinks, response.attachmentLinks) && Intrinsics.areEqual(this.ck, response.ck);
    }

    public int hashCode() {
        return (((((((((((Response$$ExternalSyntheticBackport0.m0m(this.hls) * 31) + this.videoImage.hashCode()) * 31) + this.videoSource.hashCode()) * 31) + this.securedLink.hashCode()) * 31) + this.downloadLinks.hashCode()) * 31) + this.attachmentLinks.hashCode()) * 31) + this.ck.hashCode();
    }

    @NotNull
    public String toString() {
        return "Response(hls=" + this.hls + ", videoImage=" + this.videoImage + ", videoSource=" + this.videoSource + ", securedLink=" + this.securedLink + ", downloadLinks=" + this.downloadLinks + ", attachmentLinks=" + this.attachmentLinks + ", ck=" + this.ck + ')';
    }

    public Response(boolean hls, @NotNull String videoImage, @NotNull String videoSource, @NotNull String securedLink, @NotNull List<? extends Object> list, @NotNull List<? extends Object> list2, @NotNull String ck) {
        this.hls = hls;
        this.videoImage = videoImage;
        this.videoSource = videoSource;
        this.securedLink = securedLink;
        this.downloadLinks = list;
        this.attachmentLinks = list2;
        this.ck = ck;
    }

    public final boolean getHls() {
        return this.hls;
    }

    @NotNull
    public final String getVideoImage() {
        return this.videoImage;
    }

    @NotNull
    public final String getVideoSource() {
        return this.videoSource;
    }

    @NotNull
    public final String getSecuredLink() {
        return this.securedLink;
    }

    @NotNull
    public final List<Object> getDownloadLinks() {
        return this.downloadLinks;
    }

    @NotNull
    public final List<Object> getAttachmentLinks() {
        return this.attachmentLinks;
    }

    @NotNull
    public final String getCk() {
        return this.ck;
    }
}
