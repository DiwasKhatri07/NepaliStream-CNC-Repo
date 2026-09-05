package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayFyProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayFyProvider/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006%"}, d2 = {"Lcom/cncverse/PlayFyStreamEntry;", "", "id", "", "title", "", "link", "api", "type", "webLink", "defaultLanguage", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getLink", "getApi", "getType", "getWebLink", "getDefaultLanguage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/PlayFyStreamEntry;", "equals", "", "other", "hashCode", "toString", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayFyStreamEntry {

    @Nullable
    private final String api;

    @Nullable
    private final String defaultLanguage;

    @Nullable
    private final Integer id;

    @Nullable
    private final String link;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    @Nullable
    private final String webLink;

    public static /* synthetic */ PlayFyStreamEntry copy$default(PlayFyStreamEntry playFyStreamEntry, Integer num, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            num = playFyStreamEntry.id;
        }
        if ((i & 2) != 0) {
            str = playFyStreamEntry.title;
        }
        if ((i & 4) != 0) {
            str2 = playFyStreamEntry.link;
        }
        if ((i & 8) != 0) {
            str3 = playFyStreamEntry.api;
        }
        if ((i & 16) != 0) {
            str4 = playFyStreamEntry.type;
        }
        if ((i & 32) != 0) {
            str5 = playFyStreamEntry.webLink;
        }
        if ((i & 64) != 0) {
            str6 = playFyStreamEntry.defaultLanguage;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        String str10 = str2;
        return playFyStreamEntry.copy(num, str, str10, str3, str9, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getApi() {
        return this.api;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    @NotNull
    public final PlayFyStreamEntry copy(@Nullable Integer id, @Nullable String title, @Nullable String link, @Nullable String api, @Nullable String type, @Nullable String webLink, @Nullable String defaultLanguage) {
        return new PlayFyStreamEntry(id, title, link, api, type, webLink, defaultLanguage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayFyStreamEntry)) {
            return false;
        }
        PlayFyStreamEntry playFyStreamEntry = (PlayFyStreamEntry) other;
        return Intrinsics.areEqual(this.id, playFyStreamEntry.id) && Intrinsics.areEqual(this.title, playFyStreamEntry.title) && Intrinsics.areEqual(this.link, playFyStreamEntry.link) && Intrinsics.areEqual(this.api, playFyStreamEntry.api) && Intrinsics.areEqual(this.type, playFyStreamEntry.type) && Intrinsics.areEqual(this.webLink, playFyStreamEntry.webLink) && Intrinsics.areEqual(this.defaultLanguage, playFyStreamEntry.defaultLanguage);
    }

    public int hashCode() {
        return ((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.api == null ? 0 : this.api.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.webLink == null ? 0 : this.webLink.hashCode())) * 31) + (this.defaultLanguage != null ? this.defaultLanguage.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlayFyStreamEntry(id=" + this.id + ", title=" + this.title + ", link=" + this.link + ", api=" + this.api + ", type=" + this.type + ", webLink=" + this.webLink + ", defaultLanguage=" + this.defaultLanguage + ')';
    }

    public PlayFyStreamEntry(@Nullable Integer id, @Nullable String title, @Nullable String link, @Nullable String api, @Nullable String type, @Nullable String webLink, @Nullable String defaultLanguage) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.api = api;
        this.type = type;
        this.webLink = webLink;
        this.defaultLanguage = defaultLanguage;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final String getApi() {
        return this.api;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getWebLink() {
        return this.webLink;
    }

    @Nullable
    public final String getDefaultLanguage() {
        return this.defaultLanguage;
    }
}
