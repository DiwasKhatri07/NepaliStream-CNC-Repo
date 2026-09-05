package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0014HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J¥\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0014\u0010>\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010@\u001a\u00020AHÖ\u0081\u0004J\n\u0010B\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a¨\u0006C"}, d2 = {"Lcom/MPlayer/MovieStream;", "", "provider", "", "dash", "Lcom/MPlayer/MovieDash;", "hls", "Lcom/MPlayer/MovieHls;", "drmProtect", "", "mxplay", "Lcom/MPlayer/MovieMxplay;", "youtube", "sony", "altBalaji", "thirdParty", "Lcom/MPlayer/MovieThirdParty;", "videoHash", "adTagProvider", "download", "Lcom/MPlayer/MovieDownload;", "watermark", "aspectRatio", "<init>", "(Ljava/lang/String;Lcom/MPlayer/MovieDash;Lcom/MPlayer/MovieHls;ZLcom/MPlayer/MovieMxplay;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/MPlayer/MovieThirdParty;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/MovieDownload;Ljava/lang/Object;Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "getDash", "()Lcom/MPlayer/MovieDash;", "getHls", "()Lcom/MPlayer/MovieHls;", "getDrmProtect", "()Z", "getMxplay", "()Lcom/MPlayer/MovieMxplay;", "getYoutube", "()Ljava/lang/Object;", "getSony", "getAltBalaji", "getThirdParty", "()Lcom/MPlayer/MovieThirdParty;", "getVideoHash", "getAdTagProvider", "getDownload", "()Lcom/MPlayer/MovieDownload;", "getWatermark", "getAspectRatio", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieStream {

    @NotNull
    private final String adTagProvider;

    @Nullable
    private final Object altBalaji;

    @NotNull
    private final String aspectRatio;

    @Nullable
    private final MovieDash dash;

    @NotNull
    private final MovieDownload download;
    private final boolean drmProtect;

    @Nullable
    private final MovieHls hls;

    @Nullable
    private final MovieMxplay mxplay;

    @NotNull
    private final String provider;

    @Nullable
    private final Object sony;

    @Nullable
    private final MovieThirdParty thirdParty;

    @NotNull
    private final String videoHash;

    @Nullable
    private final Object watermark;

    @Nullable
    private final Object youtube;

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVideoHash() {
        return this.videoHash;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAdTagProvider() {
        return this.adTagProvider;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final MovieDownload getDownload() {
        return this.download;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Object getWatermark() {
        return this.watermark;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getAspectRatio() {
        return this.aspectRatio;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MovieDash getDash() {
        return this.dash;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MovieHls getHls() {
        return this.hls;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getDrmProtect() {
        return this.drmProtect;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MovieMxplay getMxplay() {
        return this.mxplay;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getYoutube() {
        return this.youtube;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getSony() {
        return this.sony;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Object getAltBalaji() {
        return this.altBalaji;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MovieThirdParty getThirdParty() {
        return this.thirdParty;
    }

    @NotNull
    public final MovieStream copy(@NotNull String provider, @Nullable MovieDash dash, @Nullable MovieHls hls, boolean drmProtect, @Nullable MovieMxplay mxplay, @Nullable Object youtube, @Nullable Object sony, @Nullable Object altBalaji, @Nullable MovieThirdParty thirdParty, @NotNull String videoHash, @NotNull String adTagProvider, @NotNull MovieDownload download, @Nullable Object watermark, @NotNull String aspectRatio) {
        return new MovieStream(provider, dash, hls, drmProtect, mxplay, youtube, sony, altBalaji, thirdParty, videoHash, adTagProvider, download, watermark, aspectRatio);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieStream)) {
            return false;
        }
        MovieStream movieStream = (MovieStream) other;
        return Intrinsics.areEqual(this.provider, movieStream.provider) && Intrinsics.areEqual(this.dash, movieStream.dash) && Intrinsics.areEqual(this.hls, movieStream.hls) && this.drmProtect == movieStream.drmProtect && Intrinsics.areEqual(this.mxplay, movieStream.mxplay) && Intrinsics.areEqual(this.youtube, movieStream.youtube) && Intrinsics.areEqual(this.sony, movieStream.sony) && Intrinsics.areEqual(this.altBalaji, movieStream.altBalaji) && Intrinsics.areEqual(this.thirdParty, movieStream.thirdParty) && Intrinsics.areEqual(this.videoHash, movieStream.videoHash) && Intrinsics.areEqual(this.adTagProvider, movieStream.adTagProvider) && Intrinsics.areEqual(this.download, movieStream.download) && Intrinsics.areEqual(this.watermark, movieStream.watermark) && Intrinsics.areEqual(this.aspectRatio, movieStream.aspectRatio);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.provider.hashCode() * 31) + (this.dash == null ? 0 : this.dash.hashCode())) * 31) + (this.hls == null ? 0 : this.hls.hashCode())) * 31) + MovieStream$$ExternalSyntheticBackport0.m26m(this.drmProtect)) * 31) + (this.mxplay == null ? 0 : this.mxplay.hashCode())) * 31) + (this.youtube == null ? 0 : this.youtube.hashCode())) * 31) + (this.sony == null ? 0 : this.sony.hashCode())) * 31) + (this.altBalaji == null ? 0 : this.altBalaji.hashCode())) * 31) + (this.thirdParty == null ? 0 : this.thirdParty.hashCode())) * 31) + this.videoHash.hashCode()) * 31) + this.adTagProvider.hashCode()) * 31) + this.download.hashCode()) * 31) + (this.watermark != null ? this.watermark.hashCode() : 0)) * 31) + this.aspectRatio.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieStream(provider=").append(this.provider).append(", dash=").append(this.dash).append(", hls=").append(this.hls).append(", drmProtect=").append(this.drmProtect).append(", mxplay=").append(this.mxplay).append(", youtube=").append(this.youtube).append(", sony=").append(this.sony).append(", altBalaji=").append(this.altBalaji).append(", thirdParty=").append(this.thirdParty).append(", videoHash=").append(this.videoHash).append(", adTagProvider=").append(this.adTagProvider).append(", download=");
        sb.append(this.download).append(", watermark=").append(this.watermark).append(", aspectRatio=").append(this.aspectRatio).append(')');
        return sb.toString();
    }

    public MovieStream(@NotNull String provider, @Nullable MovieDash dash, @Nullable MovieHls hls, boolean drmProtect, @Nullable MovieMxplay mxplay, @Nullable Object youtube, @Nullable Object sony, @Nullable Object altBalaji, @Nullable MovieThirdParty thirdParty, @NotNull String videoHash, @NotNull String adTagProvider, @NotNull MovieDownload download, @Nullable Object watermark, @NotNull String aspectRatio) {
        this.provider = provider;
        this.dash = dash;
        this.hls = hls;
        this.drmProtect = drmProtect;
        this.mxplay = mxplay;
        this.youtube = youtube;
        this.sony = sony;
        this.altBalaji = altBalaji;
        this.thirdParty = thirdParty;
        this.videoHash = videoHash;
        this.adTagProvider = adTagProvider;
        this.download = download;
        this.watermark = watermark;
        this.aspectRatio = aspectRatio;
    }

    @NotNull
    public final String getProvider() {
        return this.provider;
    }

    @Nullable
    public final MovieDash getDash() {
        return this.dash;
    }

    @Nullable
    public final MovieHls getHls() {
        return this.hls;
    }

    public final boolean getDrmProtect() {
        return this.drmProtect;
    }

    @Nullable
    public final MovieMxplay getMxplay() {
        return this.mxplay;
    }

    @Nullable
    public final Object getYoutube() {
        return this.youtube;
    }

    @Nullable
    public final Object getSony() {
        return this.sony;
    }

    @Nullable
    public final Object getAltBalaji() {
        return this.altBalaji;
    }

    @Nullable
    public final MovieThirdParty getThirdParty() {
        return this.thirdParty;
    }

    @NotNull
    public final String getVideoHash() {
        return this.videoHash;
    }

    @NotNull
    public final String getAdTagProvider() {
        return this.adTagProvider;
    }

    @NotNull
    public final MovieDownload getDownload() {
        return this.download;
    }

    @Nullable
    public final Object getWatermark() {
        return this.watermark;
    }

    @NotNull
    public final String getAspectRatio() {
        return this.aspectRatio;
    }
}
