package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/SourceUrl;", "", "sourceUrl", "", "sourceName", "downloads", "Lcom/phisher98/AnichiDownloads;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/AnichiDownloads;)V", "getSourceUrl", "()Ljava/lang/String;", "getSourceName", "getDownloads", "()Lcom/phisher98/AnichiDownloads;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SourceUrl {

    @Nullable
    private final AnichiDownloads downloads;

    @NotNull
    private final String sourceName;

    @NotNull
    private final String sourceUrl;

    public static /* synthetic */ SourceUrl copy$default(SourceUrl sourceUrl, String str, String str2, AnichiDownloads anichiDownloads, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sourceUrl.sourceUrl;
        }
        if ((i & 2) != 0) {
            str2 = sourceUrl.sourceName;
        }
        if ((i & 4) != 0) {
            anichiDownloads = sourceUrl.downloads;
        }
        return sourceUrl.copy(str, str2, anichiDownloads);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AnichiDownloads getDownloads() {
        return this.downloads;
    }

    @NotNull
    public final SourceUrl copy(@NotNull String sourceUrl, @NotNull String sourceName, @Nullable AnichiDownloads downloads) {
        return new SourceUrl(sourceUrl, sourceName, downloads);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceUrl)) {
            return false;
        }
        SourceUrl sourceUrl = (SourceUrl) other;
        return Intrinsics.areEqual(this.sourceUrl, sourceUrl.sourceUrl) && Intrinsics.areEqual(this.sourceName, sourceUrl.sourceName) && Intrinsics.areEqual(this.downloads, sourceUrl.downloads);
    }

    public int hashCode() {
        return (((this.sourceUrl.hashCode() * 31) + this.sourceName.hashCode()) * 31) + (this.downloads == null ? 0 : this.downloads.hashCode());
    }

    @NotNull
    public String toString() {
        return "SourceUrl(sourceUrl=" + this.sourceUrl + ", sourceName=" + this.sourceName + ", downloads=" + this.downloads + ')';
    }

    public SourceUrl(@NotNull String sourceUrl, @NotNull String sourceName, @Nullable AnichiDownloads downloads) {
        this.sourceUrl = sourceUrl;
        this.sourceName = sourceName;
        this.downloads = downloads;
    }

    public /* synthetic */ SourceUrl(String str, String str2, AnichiDownloads anichiDownloads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : anichiDownloads);
    }

    @NotNull
    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    @NotNull
    public final String getSourceName() {
        return this.sourceName;
    }

    @Nullable
    public final AnichiDownloads getDownloads() {
        return this.downloads;
    }
}
