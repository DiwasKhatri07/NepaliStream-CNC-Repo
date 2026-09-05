package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/AnichiDownloads;", "", "sourceName", "", "downloadUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "getDownloadUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiDownloads {

    @Nullable
    private final String downloadUrl;

    @Nullable
    private final String sourceName;

    /* JADX WARN: Illegal instructions before constructor call */
    public AnichiDownloads() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ AnichiDownloads copy$default(AnichiDownloads anichiDownloads, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anichiDownloads.sourceName;
        }
        if ((i & 2) != 0) {
            str2 = anichiDownloads.downloadUrl;
        }
        return anichiDownloads.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @NotNull
    public final AnichiDownloads copy(@Nullable String sourceName, @Nullable String downloadUrl) {
        return new AnichiDownloads(sourceName, downloadUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnichiDownloads)) {
            return false;
        }
        AnichiDownloads anichiDownloads = (AnichiDownloads) other;
        return Intrinsics.areEqual(this.sourceName, anichiDownloads.sourceName) && Intrinsics.areEqual(this.downloadUrl, anichiDownloads.downloadUrl);
    }

    public int hashCode() {
        return ((this.sourceName == null ? 0 : this.sourceName.hashCode()) * 31) + (this.downloadUrl != null ? this.downloadUrl.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnichiDownloads(sourceName=" + this.sourceName + ", downloadUrl=" + this.downloadUrl + ')';
    }

    public AnichiDownloads(@Nullable String sourceName, @Nullable String downloadUrl) {
        this.sourceName = sourceName;
        this.downloadUrl = downloadUrl;
    }

    public /* synthetic */ AnichiDownloads(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getSourceName() {
        return this.sourceName;
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }
}
