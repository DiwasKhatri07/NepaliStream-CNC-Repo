package com.idlix;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JN\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lcom/idlix/Iframe;", "", "code", "", "url", "expiresAt", "", "subtitles", "", "Lcom/idlix/Subtitle;", "videoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getUrl", "getExpiresAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSubtitles", "()Ljava/util/List;", "getVideoId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;)Lcom/idlix/Iframe;", "equals", "", "other", "hashCode", "", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Iframe {

    @Nullable
    private final String code;

    @Nullable
    private final Long expiresAt;

    @NotNull
    private final List<Subtitle> subtitles;

    @Nullable
    private final String url;

    @Nullable
    private final String videoId;

    public Iframe() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Iframe copy$default(Iframe iframe, String str, String str2, Long l, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iframe.code;
        }
        if ((i & 2) != 0) {
            str2 = iframe.url;
        }
        if ((i & 4) != 0) {
            l = iframe.expiresAt;
        }
        if ((i & 8) != 0) {
            list = iframe.subtitles;
        }
        if ((i & 16) != 0) {
            str3 = iframe.videoId;
        }
        String str4 = str3;
        Long l2 = l;
        return iframe.copy(str, str2, l2, list, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getExpiresAt() {
        return this.expiresAt;
    }

    @NotNull
    public final List<Subtitle> component4() {
        return this.subtitles;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    @NotNull
    public final Iframe copy(@Nullable String code, @Nullable String url, @Nullable Long expiresAt, @NotNull List<Subtitle> subtitles, @Nullable String videoId) {
        return new Iframe(code, url, expiresAt, subtitles, videoId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Iframe)) {
            return false;
        }
        Iframe iframe = (Iframe) other;
        return Intrinsics.areEqual(this.code, iframe.code) && Intrinsics.areEqual(this.url, iframe.url) && Intrinsics.areEqual(this.expiresAt, iframe.expiresAt) && Intrinsics.areEqual(this.subtitles, iframe.subtitles) && Intrinsics.areEqual(this.videoId, iframe.videoId);
    }

    public int hashCode() {
        return ((((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.expiresAt == null ? 0 : this.expiresAt.hashCode())) * 31) + this.subtitles.hashCode()) * 31) + (this.videoId != null ? this.videoId.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Iframe(code=" + this.code + ", url=" + this.url + ", expiresAt=" + this.expiresAt + ", subtitles=" + this.subtitles + ", videoId=" + this.videoId + ')';
    }

    public Iframe(@Nullable String code, @Nullable String url, @Nullable Long expiresAt, @NotNull List<Subtitle> list, @Nullable String videoId) {
        this.code = code;
        this.url = url;
        this.expiresAt = expiresAt;
        this.subtitles = list;
        this.videoId = videoId;
    }

    public /* synthetic */ Iframe(String str, String str2, Long l, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : str3);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Long getExpiresAt() {
        return this.expiresAt;
    }

    @NotNull
    public final List<Subtitle> getSubtitles() {
        return this.subtitles;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }
}
