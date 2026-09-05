package com.Fibwatch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/Fibwatch/EpisodeItem;", "", "ep_key", "", "display", "title", "url", "is_current", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEp_key", "()Ljava/lang/String;", "getDisplay", "getTitle", "getUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/Fibwatch/EpisodeItem;", "equals", "other", "hashCode", "", "toString", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeItem {

    @Nullable
    private final String display;

    @Nullable
    private final String ep_key;

    @Nullable
    private final Boolean is_current;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public static /* synthetic */ EpisodeItem copy$default(EpisodeItem episodeItem, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeItem.ep_key;
        }
        if ((i & 2) != 0) {
            str2 = episodeItem.display;
        }
        if ((i & 4) != 0) {
            str3 = episodeItem.title;
        }
        if ((i & 8) != 0) {
            str4 = episodeItem.url;
        }
        if ((i & 16) != 0) {
            bool = episodeItem.is_current;
        }
        Boolean bool2 = bool;
        String str5 = str3;
        return episodeItem.copy(str, str2, str5, str4, bool2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEp_key() {
        return this.ep_key;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplay() {
        return this.display;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIs_current() {
        return this.is_current;
    }

    @NotNull
    public final EpisodeItem copy(@Nullable String ep_key, @Nullable String display, @Nullable String title, @Nullable String url, @Nullable Boolean is_current) {
        return new EpisodeItem(ep_key, display, title, url, is_current);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeItem)) {
            return false;
        }
        EpisodeItem episodeItem = (EpisodeItem) other;
        return Intrinsics.areEqual(this.ep_key, episodeItem.ep_key) && Intrinsics.areEqual(this.display, episodeItem.display) && Intrinsics.areEqual(this.title, episodeItem.title) && Intrinsics.areEqual(this.url, episodeItem.url) && Intrinsics.areEqual(this.is_current, episodeItem.is_current);
    }

    public int hashCode() {
        return ((((((((this.ep_key == null ? 0 : this.ep_key.hashCode()) * 31) + (this.display == null ? 0 : this.display.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.is_current != null ? this.is_current.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeItem(ep_key=" + this.ep_key + ", display=" + this.display + ", title=" + this.title + ", url=" + this.url + ", is_current=" + this.is_current + ')';
    }

    public EpisodeItem(@Nullable String ep_key, @Nullable String display, @Nullable String title, @Nullable String url, @Nullable Boolean is_current) {
        this.ep_key = ep_key;
        this.display = display;
        this.title = title;
        this.url = url;
        this.is_current = is_current;
    }

    @Nullable
    public final String getEp_key() {
        return this.ep_key;
    }

    @Nullable
    public final String getDisplay() {
        return this.display;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Boolean is_current() {
        return this.is_current;
    }
}
