package com.OneTouchTV;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OneTouchTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003Jg\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/OneTouchTV/SourceItem;", "", "type", "", "contentId", "id", "name", "quality", "url", "headers", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getType", "()Ljava/lang/String;", "getContentId", "getId", "getName", "getQuality", "getUrl", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SourceItem {

    @Nullable
    private final String contentId;

    @NotNull
    private final Map<String, String> headers;

    @Nullable
    private final String id;

    @Nullable
    private final String name;

    @Nullable
    private final String quality;

    @Nullable
    private final String type;

    @Nullable
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SourceItem copy$default(SourceItem sourceItem, String str, String str2, String str3, String str4, String str5, String str6, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sourceItem.type;
        }
        if ((i & 2) != 0) {
            str2 = sourceItem.contentId;
        }
        if ((i & 4) != 0) {
            str3 = sourceItem.id;
        }
        if ((i & 8) != 0) {
            str4 = sourceItem.name;
        }
        if ((i & 16) != 0) {
            str5 = sourceItem.quality;
        }
        if ((i & 32) != 0) {
            str6 = sourceItem.url;
        }
        if ((i & 64) != 0) {
            map = sourceItem.headers;
        }
        String str7 = str6;
        Map map2 = map;
        String str8 = str5;
        String str9 = str3;
        return sourceItem.copy(str, str2, str9, str4, str8, str7, map2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final Map<String, String> component7() {
        return this.headers;
    }

    @NotNull
    public final SourceItem copy(@Nullable String type, @Nullable String contentId, @Nullable String id, @Nullable String name, @Nullable String quality, @Nullable String url, @NotNull Map<String, String> headers) {
        return new SourceItem(type, contentId, id, name, quality, url, headers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceItem)) {
            return false;
        }
        SourceItem sourceItem = (SourceItem) other;
        return Intrinsics.areEqual(this.type, sourceItem.type) && Intrinsics.areEqual(this.contentId, sourceItem.contentId) && Intrinsics.areEqual(this.id, sourceItem.id) && Intrinsics.areEqual(this.name, sourceItem.name) && Intrinsics.areEqual(this.quality, sourceItem.quality) && Intrinsics.areEqual(this.url, sourceItem.url) && Intrinsics.areEqual(this.headers, sourceItem.headers);
    }

    public int hashCode() {
        return ((((((((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.contentId == null ? 0 : this.contentId.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + this.headers.hashCode();
    }

    @NotNull
    public String toString() {
        return "SourceItem(type=" + this.type + ", contentId=" + this.contentId + ", id=" + this.id + ", name=" + this.name + ", quality=" + this.quality + ", url=" + this.url + ", headers=" + this.headers + ')';
    }

    public SourceItem(@Nullable String type, @Nullable String contentId, @Nullable String id, @Nullable String name, @Nullable String quality, @Nullable String url, @NotNull Map<String, String> map) {
        this.type = type;
        this.contentId = contentId;
        this.id = id;
        this.name = name;
        this.quality = quality;
        this.url = url;
        this.headers = map;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }
}
