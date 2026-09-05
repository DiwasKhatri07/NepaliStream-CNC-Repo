package com.OneTouchTV;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OneTouchTV/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/OneTouchTV/ChannelItem;", "", "title", "", "category", "logo", "id", "streamingUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getCategory", "getLogo", "getId", "getStreamingUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ChannelItem {

    @Nullable
    private final String category;

    @Nullable
    private final String id;

    @Nullable
    private final String logo;

    @Nullable
    private final String streamingUrl;

    @Nullable
    private final String title;

    public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelItem.title;
        }
        if ((i & 2) != 0) {
            str2 = channelItem.category;
        }
        if ((i & 4) != 0) {
            str3 = channelItem.logo;
        }
        if ((i & 8) != 0) {
            str4 = channelItem.id;
        }
        if ((i & 16) != 0) {
            str5 = channelItem.streamingUrl;
        }
        String str6 = str5;
        String str7 = str3;
        return channelItem.copy(str, str2, str7, str4, str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStreamingUrl() {
        return this.streamingUrl;
    }

    @NotNull
    public final ChannelItem copy(@Nullable String title, @Nullable String category, @Nullable String logo, @Nullable String id, @Nullable String streamingUrl) {
        return new ChannelItem(title, category, logo, id, streamingUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelItem)) {
            return false;
        }
        ChannelItem channelItem = (ChannelItem) other;
        return Intrinsics.areEqual(this.title, channelItem.title) && Intrinsics.areEqual(this.category, channelItem.category) && Intrinsics.areEqual(this.logo, channelItem.logo) && Intrinsics.areEqual(this.id, channelItem.id) && Intrinsics.areEqual(this.streamingUrl, channelItem.streamingUrl);
    }

    public int hashCode() {
        return ((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.streamingUrl != null ? this.streamingUrl.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ChannelItem(title=" + this.title + ", category=" + this.category + ", logo=" + this.logo + ", id=" + this.id + ", streamingUrl=" + this.streamingUrl + ')';
    }

    public ChannelItem(@Nullable String title, @Nullable String category, @Nullable String logo, @Nullable String id, @Nullable String streamingUrl) {
        this.title = title;
        this.category = category;
        this.logo = logo;
        this.id = id;
        this.streamingUrl = streamingUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getStreamingUrl() {
        return this.streamingUrl;
    }
}
