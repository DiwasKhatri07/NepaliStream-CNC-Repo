package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\u0087\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0014\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0007\u0010\u0002¨\u00063"}, d2 = {"Lcom/MPlayer/EpisodesParser;", "", "id", "", "style", "items", "", "Lcom/MPlayer/EpisodesItem;", "next", "previous", "name", "webUrl", "channelDetails", "features", "tournament", "ascend", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getId", "()Ljava/lang/String;", "getStyle", "getItems", "()Ljava/util/List;", "getNext", "getPrevious", "getName", "getWebUrl", "()Ljava/lang/Object;", "getChannelDetails", "getFeatures", "getTournament", "getAscend", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodesParser {
    private final boolean ascend;

    @Nullable
    private final Object channelDetails;

    @Nullable
    private final Object features;

    @NotNull
    private final String id;

    @NotNull
    private final List<EpisodesItem> items;

    @NotNull
    private final String name;

    @Nullable
    private final String next;

    @NotNull
    private final String previous;

    @NotNull
    private final String style;

    @Nullable
    private final Object tournament;

    @Nullable
    private final Object webUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodesParser copy$default(EpisodesParser episodesParser, String str, String str2, List list, String str3, String str4, String str5, Object obj, Object obj2, Object obj3, Object obj4, boolean z, int i, Object obj5) {
        if ((i & 1) != 0) {
            str = episodesParser.id;
        }
        if ((i & 2) != 0) {
            str2 = episodesParser.style;
        }
        if ((i & 4) != 0) {
            list = episodesParser.items;
        }
        if ((i & 8) != 0) {
            str3 = episodesParser.next;
        }
        if ((i & 16) != 0) {
            str4 = episodesParser.previous;
        }
        if ((i & 32) != 0) {
            str5 = episodesParser.name;
        }
        if ((i & 64) != 0) {
            obj = episodesParser.webUrl;
        }
        if ((i & 128) != 0) {
            obj2 = episodesParser.channelDetails;
        }
        if ((i & 256) != 0) {
            obj3 = episodesParser.features;
        }
        if ((i & 512) != 0) {
            obj4 = episodesParser.tournament;
        }
        if ((i & 1024) != 0) {
            z = episodesParser.ascend;
        }
        Object obj6 = obj4;
        boolean z2 = z;
        Object obj7 = obj2;
        Object obj8 = obj3;
        String str6 = str5;
        Object obj9 = obj;
        String str7 = str4;
        List list2 = list;
        return episodesParser.copy(str, str2, list2, str3, str7, str6, obj9, obj7, obj8, obj6, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Object getTournament() {
        return this.tournament;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getAscend() {
        return this.ascend;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    @NotNull
    public final List<EpisodesItem> component3() {
        return this.items;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNext() {
        return this.next;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrevious() {
        return this.previous;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getWebUrl() {
        return this.webUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Object getChannelDetails() {
        return this.channelDetails;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Object getFeatures() {
        return this.features;
    }

    @NotNull
    public final EpisodesParser copy(@NotNull String id, @NotNull String style, @NotNull List<EpisodesItem> items, @Nullable String next, @NotNull String previous, @NotNull String name, @Nullable Object webUrl, @Nullable Object channelDetails, @Nullable Object features, @Nullable Object tournament, boolean ascend) {
        return new EpisodesParser(id, style, items, next, previous, name, webUrl, channelDetails, features, tournament, ascend);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodesParser)) {
            return false;
        }
        EpisodesParser episodesParser = (EpisodesParser) other;
        return Intrinsics.areEqual(this.id, episodesParser.id) && Intrinsics.areEqual(this.style, episodesParser.style) && Intrinsics.areEqual(this.items, episodesParser.items) && Intrinsics.areEqual(this.next, episodesParser.next) && Intrinsics.areEqual(this.previous, episodesParser.previous) && Intrinsics.areEqual(this.name, episodesParser.name) && Intrinsics.areEqual(this.webUrl, episodesParser.webUrl) && Intrinsics.areEqual(this.channelDetails, episodesParser.channelDetails) && Intrinsics.areEqual(this.features, episodesParser.features) && Intrinsics.areEqual(this.tournament, episodesParser.tournament) && this.ascend == episodesParser.ascend;
    }

    public int hashCode() {
        return (((((((((((((((((((this.id.hashCode() * 31) + this.style.hashCode()) * 31) + this.items.hashCode()) * 31) + (this.next == null ? 0 : this.next.hashCode())) * 31) + this.previous.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.webUrl == null ? 0 : this.webUrl.hashCode())) * 31) + (this.channelDetails == null ? 0 : this.channelDetails.hashCode())) * 31) + (this.features == null ? 0 : this.features.hashCode())) * 31) + (this.tournament != null ? this.tournament.hashCode() : 0)) * 31) + EpisodesParser$$ExternalSyntheticBackport0.m9m(this.ascend);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EpisodesParser(id=").append(this.id).append(", style=").append(this.style).append(", items=").append(this.items).append(", next=").append(this.next).append(", previous=").append(this.previous).append(", name=").append(this.name).append(", webUrl=").append(this.webUrl).append(", channelDetails=").append(this.channelDetails).append(", features=").append(this.features).append(", tournament=").append(this.tournament).append(", ascend=").append(this.ascend).append(')');
        return sb.toString();
    }

    public EpisodesParser(@NotNull String id, @NotNull String style, @NotNull List<EpisodesItem> list, @Nullable String next, @NotNull String previous, @NotNull String name, @Nullable Object webUrl, @Nullable Object channelDetails, @Nullable Object features, @Nullable Object tournament, boolean ascend) {
        this.id = id;
        this.style = style;
        this.items = list;
        this.next = next;
        this.previous = previous;
        this.name = name;
        this.webUrl = webUrl;
        this.channelDetails = channelDetails;
        this.features = features;
        this.tournament = tournament;
        this.ascend = ascend;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getStyle() {
        return this.style;
    }

    @NotNull
    public final List<EpisodesItem> getItems() {
        return this.items;
    }

    @Nullable
    public final String getNext() {
        return this.next;
    }

    @NotNull
    public final String getPrevious() {
        return this.previous;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Object getWebUrl() {
        return this.webUrl;
    }

    @Nullable
    public final Object getChannelDetails() {
        return this.channelDetails;
    }

    @Nullable
    public final Object getFeatures() {
        return this.features;
    }

    @Nullable
    public final Object getTournament() {
        return this.tournament;
    }

    public final boolean getAscend() {
        return this.ascend;
    }
}
