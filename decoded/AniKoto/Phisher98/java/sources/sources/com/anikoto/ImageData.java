package com.anikoto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnikotoUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniKoto/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/anikoto/ImageData;", "", "coverType", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCoverType", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AniKoto"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ImageData {

    @Nullable
    private final String coverType;

    @Nullable
    private final String url;

    /* JADX WARN: Illegal instructions before constructor call */
    public ImageData() {
        String str = null;
        this(str, str, 3, str);
    }

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
    public final ImageData copy(@Nullable String coverType, @Nullable String url) {
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

    public ImageData(@Nullable String coverType, @Nullable String url) {
        this.coverType = coverType;
        this.url = url;
    }

    public /* synthetic */ ImageData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
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
