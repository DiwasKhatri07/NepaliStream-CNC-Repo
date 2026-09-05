package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SKTechProvider/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\\\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\n\u0010\u0011¨\u0006#"}, d2 = {"Lcom/cncverse/SKTechChannelData;", "", "name", "", "logo", "visible", "", "links", "link_names", "", "is_playlist", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "getLogo", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLinks", "getLink_names", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/cncverse/SKTechChannelData;", "equals", "other", "hashCode", "", "toString", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SKTechChannelData {

    @Nullable
    private final Boolean is_playlist;

    @Nullable
    private final List<String> link_names;

    @Nullable
    private final String links;

    @Nullable
    private final String logo;

    @Nullable
    private final String name;

    @Nullable
    private final Boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SKTechChannelData copy$default(SKTechChannelData sKTechChannelData, String str, String str2, Boolean bool, String str3, List list, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sKTechChannelData.name;
        }
        if ((i & 2) != 0) {
            str2 = sKTechChannelData.logo;
        }
        if ((i & 4) != 0) {
            bool = sKTechChannelData.visible;
        }
        if ((i & 8) != 0) {
            str3 = sKTechChannelData.links;
        }
        if ((i & 16) != 0) {
            list = sKTechChannelData.link_names;
        }
        if ((i & 32) != 0) {
            bool2 = sKTechChannelData.is_playlist;
        }
        List list2 = list;
        Boolean bool3 = bool2;
        return sKTechChannelData.copy(str, str2, bool, str3, list2, bool3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getVisible() {
        return this.visible;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLinks() {
        return this.links;
    }

    @Nullable
    public final List<String> component5() {
        return this.link_names;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIs_playlist() {
        return this.is_playlist;
    }

    @NotNull
    public final SKTechChannelData copy(@Nullable String name, @Nullable String logo, @Nullable Boolean visible, @Nullable String links, @Nullable List<String> link_names, @Nullable Boolean is_playlist) {
        return new SKTechChannelData(name, logo, visible, links, link_names, is_playlist);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SKTechChannelData)) {
            return false;
        }
        SKTechChannelData sKTechChannelData = (SKTechChannelData) other;
        return Intrinsics.areEqual(this.name, sKTechChannelData.name) && Intrinsics.areEqual(this.logo, sKTechChannelData.logo) && Intrinsics.areEqual(this.visible, sKTechChannelData.visible) && Intrinsics.areEqual(this.links, sKTechChannelData.links) && Intrinsics.areEqual(this.link_names, sKTechChannelData.link_names) && Intrinsics.areEqual(this.is_playlist, sKTechChannelData.is_playlist);
    }

    public int hashCode() {
        return ((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.visible == null ? 0 : this.visible.hashCode())) * 31) + (this.links == null ? 0 : this.links.hashCode())) * 31) + (this.link_names == null ? 0 : this.link_names.hashCode())) * 31) + (this.is_playlist != null ? this.is_playlist.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SKTechChannelData(name=" + this.name + ", logo=" + this.logo + ", visible=" + this.visible + ", links=" + this.links + ", link_names=" + this.link_names + ", is_playlist=" + this.is_playlist + ')';
    }

    public SKTechChannelData(@Nullable String name, @Nullable String logo, @Nullable Boolean visible, @Nullable String links, @Nullable List<String> list, @Nullable Boolean is_playlist) {
        this.name = name;
        this.logo = logo;
        this.visible = visible;
        this.links = links;
        this.link_names = list;
        this.is_playlist = is_playlist;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final Boolean getVisible() {
        return this.visible;
    }

    @Nullable
    public final String getLinks() {
        return this.links;
    }

    @Nullable
    public final List<String> getLink_names() {
        return this.link_names;
    }

    @Nullable
    public final Boolean is_playlist() {
        return this.is_playlist;
    }
}
