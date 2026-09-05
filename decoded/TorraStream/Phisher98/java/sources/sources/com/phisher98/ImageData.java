package com.phisher98;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ImageData;", "", "coverType", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCoverType", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ImageData {

    @Nullable
    private final String coverType;

    @Nullable
    private final String url;

    public static /* synthetic */ ImageData copy$default(ImageData imageData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageData.coverType;
        }
        if ((i & 2) != 0) {
            str2 = imageData.url;
        }
        return imageData.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverType() {
        return this.coverType;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final ImageData copy(@JsonProperty("coverType") @Nullable String coverType, @JsonProperty("url") @Nullable String url) {
        return new ImageData(coverType, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageData)) {
            return false;
        }
        ImageData imageData = (ImageData) other;
        return Intrinsics.areEqual(this.coverType, imageData.coverType) && Intrinsics.areEqual(this.url, imageData.url);
    }

    public int hashCode() {
        return ((this.coverType == null ? 0 : this.coverType.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ImageData(coverType=" + this.coverType + ", url=" + this.url + ')';
    }

    public ImageData(@JsonProperty("coverType") @Nullable String coverType, @JsonProperty("url") @Nullable String url) {
        this.coverType = coverType;
        this.url = url;
    }

    @Nullable
    public final String getCoverType() {
        return this.coverType;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
