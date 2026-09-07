package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012$\b\u0003\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010 Jð\u0001\u0010*\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2$\b\u0003\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012HÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R'\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R-\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR3\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR'\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R)\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 Ê\u0001\f\b3\u0012\b\b4\u0012\u0004\b\u0007\u0010\u0002¨\u00062"}, d2 = {"Lcom/AniVortex/QualityStream;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "quality", "type", "url", "fallbackUrls", "", "fallback_urls", "headers", "", "expiresAt", "expires_at", "fileSizeBytes", "", "file_size_bytes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "getQuality", "getType", "getUrl", "getFallbackUrls", "()Ljava/util/List;", "getHeaders", "()Ljava/util/Map;", "getExpiresAt", "getFileSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;)Lcom/AniVortex/QualityStream;", "equals", "", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class QualityStream {

    @JsonProperty("expires_at")
    @Nullable
    private final String expiresAt;

    @JsonProperty("fallback_urls")
    @Nullable
    private final List<String> fallbackUrls;

    @JsonProperty("file_size_bytes")
    @Nullable
    private final Long fileSizeBytes;

    @JsonProperty("headers")
    @Nullable
    private final Map<String, String> headers;

    @JsonProperty("id")
    @Nullable
    private final String id;

    @JsonProperty("quality")
    @Nullable
    private final String quality;

    @JsonProperty("type")
    @Nullable
    private final String type;

    @JsonProperty("url")
    @Nullable
    private final String url;

    public QualityStream() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QualityStream copy$default(QualityStream qualityStream, String str, String str2, String str3, String str4, List list, Map map, String str5, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = qualityStream.id;
        }
        if ((i & 2) != 0) {
            str2 = qualityStream.quality;
        }
        if ((i & 4) != 0) {
            str3 = qualityStream.type;
        }
        if ((i & 8) != 0) {
            str4 = qualityStream.url;
        }
        if ((i & 16) != 0) {
            list = qualityStream.fallbackUrls;
        }
        if ((i & 32) != 0) {
            map = qualityStream.headers;
        }
        if ((i & 64) != 0) {
            str5 = qualityStream.expiresAt;
        }
        if ((i & 128) != 0) {
            l = qualityStream.fileSizeBytes;
        }
        String str6 = str5;
        Long l2 = l;
        List list2 = list;
        Map map2 = map;
        return qualityStream.copy(str, str2, str3, str4, list2, map2, str6, l2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final List<String> component5() {
        return this.fallbackUrls;
    }

    @Nullable
    public final Map<String, String> component6() {
        return this.headers;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getFileSizeBytes() {
        return this.fileSizeBytes;
    }

    @NotNull
    public final QualityStream copy(@JsonProperty("id") @Nullable String id, @JsonProperty("quality") @Nullable String quality, @JsonProperty("type") @Nullable String type, @JsonProperty("url") @Nullable String url, @JsonProperty("fallback_urls") @Nullable List<String> fallbackUrls, @JsonProperty("headers") @Nullable Map<String, String> headers, @JsonProperty("expires_at") @Nullable String expiresAt, @JsonProperty("file_size_bytes") @Nullable Long fileSizeBytes) {
        return new QualityStream(id, quality, type, url, fallbackUrls, headers, expiresAt, fileSizeBytes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QualityStream)) {
            return false;
        }
        QualityStream qualityStream = (QualityStream) other;
        return Intrinsics.areEqual(this.id, qualityStream.id) && Intrinsics.areEqual(this.quality, qualityStream.quality) && Intrinsics.areEqual(this.type, qualityStream.type) && Intrinsics.areEqual(this.url, qualityStream.url) && Intrinsics.areEqual(this.fallbackUrls, qualityStream.fallbackUrls) && Intrinsics.areEqual(this.headers, qualityStream.headers) && Intrinsics.areEqual(this.expiresAt, qualityStream.expiresAt) && Intrinsics.areEqual(this.fileSizeBytes, qualityStream.fileSizeBytes);
    }

    public int hashCode() {
        return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.fallbackUrls == null ? 0 : this.fallbackUrls.hashCode())) * 31) + (this.headers == null ? 0 : this.headers.hashCode())) * 31) + (this.expiresAt == null ? 0 : this.expiresAt.hashCode())) * 31) + (this.fileSizeBytes != null ? this.fileSizeBytes.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "QualityStream(id=" + this.id + ", quality=" + this.quality + ", type=" + this.type + ", url=" + this.url + ", fallbackUrls=" + this.fallbackUrls + ", headers=" + this.headers + ", expiresAt=" + this.expiresAt + ", fileSizeBytes=" + this.fileSizeBytes + ')';
    }

    public QualityStream(@JsonProperty("id") @Nullable String id, @JsonProperty("quality") @Nullable String quality, @JsonProperty("type") @Nullable String type, @JsonProperty("url") @Nullable String url, @JsonProperty("fallback_urls") @Nullable List<String> list, @JsonProperty("headers") @Nullable Map<String, String> map, @JsonProperty("expires_at") @Nullable String expiresAt, @JsonProperty("file_size_bytes") @Nullable Long fileSizeBytes) {
        this.id = id;
        this.quality = quality;
        this.type = type;
        this.url = url;
        this.fallbackUrls = list;
        this.headers = map;
        this.expiresAt = expiresAt;
        this.fileSizeBytes = fileSizeBytes;
    }

    public /* synthetic */ QualityStream(String str, String str2, String str3, String str4, List list, Map map, String str5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : map, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : l);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final List<String> getFallbackUrls() {
        return this.fallbackUrls;
    }

    @Nullable
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    @Nullable
    public final Long getFileSizeBytes() {
        return this.fileSizeBytes;
    }
}
