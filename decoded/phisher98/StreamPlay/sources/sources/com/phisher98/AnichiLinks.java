package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012*\b\u0003\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\u001d\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011HÆ\u0003JÒ\u0001\u0010(\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2*\b\u0003\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0014\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR%\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/phisher98/AnichiLinks;", "", "link", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "hls", "", "resolutionStr", "src", "headers", "Lcom/phisher98/Headers;", "portData", "Lcom/phisher98/PortData;", "subtitles", "Ljava/util/ArrayList;", "Lcom/phisher98/AnichiSubtitles;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/Headers;Lcom/phisher98/PortData;Ljava/util/ArrayList;)V", "getLink", "()Ljava/lang/String;", "getHls", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResolutionStr", "getSrc", "getHeaders", "()Lcom/phisher98/Headers;", "getPortData", "()Lcom/phisher98/PortData;", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/Headers;Lcom/phisher98/PortData;Ljava/util/ArrayList;)Lcom/phisher98/AnichiLinks;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiLinks {

    @Nullable
    private final Headers headers;

    @Nullable
    private final Boolean hls;

    @NotNull
    private final String link;

    @Nullable
    private final PortData portData;

    @NotNull
    private final String resolutionStr;

    @Nullable
    private final String src;

    @Nullable
    private final ArrayList<AnichiSubtitles> subtitles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnichiLinks copy$default(AnichiLinks anichiLinks, String str, Boolean bool, String str2, String str3, Headers headers, PortData portData, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anichiLinks.link;
        }
        if ((i & 2) != 0) {
            bool = anichiLinks.hls;
        }
        if ((i & 4) != 0) {
            str2 = anichiLinks.resolutionStr;
        }
        if ((i & 8) != 0) {
            str3 = anichiLinks.src;
        }
        if ((i & 16) != 0) {
            headers = anichiLinks.headers;
        }
        if ((i & 32) != 0) {
            portData = anichiLinks.portData;
        }
        if ((i & 64) != 0) {
            arrayList = anichiLinks.subtitles;
        }
        PortData portData2 = portData;
        ArrayList arrayList2 = arrayList;
        Headers headers2 = headers;
        String str4 = str2;
        return anichiLinks.copy(str, bool, str4, str3, headers2, portData2, arrayList2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getHls() {
        return this.hls;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getResolutionStr() {
        return this.resolutionStr;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PortData getPortData() {
        return this.portData;
    }

    @Nullable
    public final ArrayList<AnichiSubtitles> component7() {
        return this.subtitles;
    }

    @NotNull
    public final AnichiLinks copy(@JsonProperty("link") @NotNull String link, @JsonProperty("hls") @Nullable Boolean hls, @JsonProperty("resolutionStr") @NotNull String resolutionStr, @JsonProperty("src") @Nullable String src, @JsonProperty("headers") @Nullable Headers headers, @JsonProperty("portData") @Nullable PortData portData, @JsonProperty("subtitles") @Nullable ArrayList<AnichiSubtitles> subtitles) {
        return new AnichiLinks(link, hls, resolutionStr, src, headers, portData, subtitles);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnichiLinks)) {
            return false;
        }
        AnichiLinks anichiLinks = (AnichiLinks) other;
        return Intrinsics.areEqual(this.link, anichiLinks.link) && Intrinsics.areEqual(this.hls, anichiLinks.hls) && Intrinsics.areEqual(this.resolutionStr, anichiLinks.resolutionStr) && Intrinsics.areEqual(this.src, anichiLinks.src) && Intrinsics.areEqual(this.headers, anichiLinks.headers) && Intrinsics.areEqual(this.portData, anichiLinks.portData) && Intrinsics.areEqual(this.subtitles, anichiLinks.subtitles);
    }

    public int hashCode() {
        return (((((((((((this.link.hashCode() * 31) + (this.hls == null ? 0 : this.hls.hashCode())) * 31) + this.resolutionStr.hashCode()) * 31) + (this.src == null ? 0 : this.src.hashCode())) * 31) + (this.headers == null ? 0 : this.headers.hashCode())) * 31) + (this.portData == null ? 0 : this.portData.hashCode())) * 31) + (this.subtitles != null ? this.subtitles.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnichiLinks(link=" + this.link + ", hls=" + this.hls + ", resolutionStr=" + this.resolutionStr + ", src=" + this.src + ", headers=" + this.headers + ", portData=" + this.portData + ", subtitles=" + this.subtitles + ')';
    }

    public AnichiLinks(@JsonProperty("link") @NotNull String link, @JsonProperty("hls") @Nullable Boolean hls, @JsonProperty("resolutionStr") @NotNull String resolutionStr, @JsonProperty("src") @Nullable String src, @JsonProperty("headers") @Nullable Headers headers, @JsonProperty("portData") @Nullable PortData portData, @JsonProperty("subtitles") @Nullable ArrayList<AnichiSubtitles> arrayList) {
        this.link = link;
        this.hls = hls;
        this.resolutionStr = resolutionStr;
        this.src = src;
        this.headers = headers;
        this.portData = portData;
        this.subtitles = arrayList;
    }

    public /* synthetic */ AnichiLinks(String str, Boolean bool, String str2, String str3, Headers headers, PortData portData, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : bool, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : headers, (i & 32) != 0 ? null : portData, (i & 64) != 0 ? new ArrayList() : arrayList);
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final Boolean getHls() {
        return this.hls;
    }

    @NotNull
    public final String getResolutionStr() {
        return this.resolutionStr;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    public final Headers getHeaders() {
        return this.headers;
    }

    @Nullable
    public final PortData getPortData() {
        return this.portData;
    }

    @Nullable
    public final ArrayList<AnichiSubtitles> getSubtitles() {
        return this.subtitles;
    }
}
